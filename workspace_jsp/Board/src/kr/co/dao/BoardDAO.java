package kr.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.domain.BoardDTO;

public class BoardDAO {
	private DataSource dataFactory;
	
	public BoardDAO() {
		
		try {
			Context	ctx = new InitialContext();
				
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public List<BoardDTO> list() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board order by repRoot desc, repStep asc ";
		ResultSet rs = null;
						
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
//				String content = rs.getString("content");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");

				// 실제로는 보통 위에까지만...
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				list.add(new BoardDTO(num, writer, title, null, writeday, readcnt, repRoot, repStep, repIndent));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return list;
	}



	public void insert(BoardDTO boardDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board (num,writer, title, content, repRoot, repStep, repIndent) values (?,?,?,?,?,?,?)";
		// num 값을 여기서 만들어준다.
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			// num 값 만들어주는...반드시 커낵션을 넣어주어야 한다...
			int num = createNum(conn);	// 같은 커낵션을 가지고 작업을해야하기때문에
			
			
			pstmt.setInt(1, num);
			pstmt.setString(2,boardDTO.getWriter() );
			pstmt.setString(3, boardDTO.getTitle());
			pstmt.setString(4, boardDTO.getContent());
			pstmt.setInt(5, num);		// repRoot 는 처음이라 num 값을 받는다.
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}



	private int createNum(Connection conn) {
		PreparedStatement pstmt = null;
		
		// 가장 큰 num 값 가져온다...
		String sql = "select max(num) from board";
		ResultSet rs = null;
		Integer num = null;
		
		try {
			// 커낵션은 이미 객체가 있다...
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				// 지금은 int 로 해도 되지만
				// ???
				num = rs.getInt(1);		// 컬럼명을 모르니 그냥 1로 받는다...

				// 없으면 null 이 아니라 0을 반환
				num +=1;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// 여기서 커낵션 닫아주면 insert 다음이 실행이 안된다...
			// 그래서 여기는 닫지말고 null로...
			closeAll(rs, pstmt, null);
		}
		
		
		return num;
	}



	public BoardDTO read(int num) {
		BoardDTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board WHERE num = ?";
		
		boolean isOk =false;	// 트랜젝션 상황 변수
		
				
		try {
			conn = dataFactory.getConnection();
			
			conn.setAutoCommit(false);		// 트랜젝션 을 구현 하려면 autocommit 해제해야한다...
			
			// 조회수 증가함수.
			increaseReadCnt(conn, num);	// 넘겨받을때...conn 연결 해제하면 안된다...
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
//				글 자세히 보기라...여기까지만 있어도...
//				int repRoot = rs.getInt("repStep");
//				int repStep = rs.getInt("repStep");
//				int repIndent = rs.getInt("repIndent");
				
				// 눈에 보이는 숫자만 +1 readcnt+1
				dto = new BoardDTO(num, writer, title, content, writeday, readcnt, 0, 0, 0);
				
				// 조회수를 증가시키는 함수
				// DB에 조회수 늘린 카운트 보내기
				
				
				isOk = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {		// if/ else 작성하고 surround with 에서 다시 try/catch
				if (isOk) {		// 지금 현재 autocommit이라 위에서 설정을 autocommit 해제...
					conn.commit();
				} else {
					conn.rollback();
				} 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			closeAll(rs, pstmt, conn);
		}

		return dto;
	}



	private void increaseReadCnt(Connection conn, int num) {
		PreparedStatement pstmt = null;
		String sql = "update board set readcnt = readcnt+1 where num =?";
		
		try {
			// 커낵션은 계속 이어져 오기때문에 그대로 쓴다...
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {		
			// 조회수 수정하고 그 값을 다시 보내야 하기 때문에
			// conn 닫아주면 안된다....
			closeAll(null, pstmt, null);
		}
		
	}



	public BoardDTO updateUI(int num) {
		// read(num) 으로 넘기면 조회수가 증가가 된다...
		// 그래서 따로 만들어 주어야한다...
		BoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		String sql = "SELECT * FROM board WHERE num=?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				
				// 추가
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				// 수정할때 작성일자는 그대로
				// String writeday = rs.getString("writeday");
				// int readcnt = rs.getInt("readcnt");

				dto = new BoardDTO(num, writer, title, content, null, 0, repRoot, repStep, repIndent);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return dto;
	}



	public void update(BoardDTO boardDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		// 나중에는 수정시...작성일자든... 수정일자는 따로 변경해야한다.. 
		String sql = "UPDATE board SET writer=?, title=?, content=? WHERE num =? ";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardDTO.getWriter());
			pstmt.setString(2, boardDTO.getTitle());
			pstmt.setString(3, boardDTO.getContent());
			pstmt.setInt(4, boardDTO.getNum());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
		
		
	}



	public void delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM board where num=?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);;
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}



	public void reply(int orgnum, BoardDTO dto) {
		Connection conn = null; 
		PreparedStatement pstmt = null;
		
		
		// 댓들 다는거라 insert
		String sql = "insert into board (num,writer, title, content, repRoot, repStep, repIndent) values (?,?,?,?,?,?,?)";
		boolean isOk = false;
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);		// 트랜잭션 처리해줄려면 무조건 setAutoCommit 을 false 로....디폴트는 true
			
			int num = createNum(conn);	// 부모(원글)의 num값 가져오기...
			
			// 부모의 num 값...orgnum 
			BoardDTO orgDTO = updateUI(orgnum);	// 부모글의 DTO...repRoot, repStep, repIndent 다 있다...
			
			// 커낵션이 달라지면 트랜잭션이 발생하지 않는다...
			stepPlus1(conn, orgDTO);
			System.out.println(456);
			
			pstmt = conn.prepareStatement(sql);
			
			
			
//			해당 답글의 repRoot : 1 .원글의 repRoot값을 그대로 넘겨받음...
//			해당 답글의 repStep : 
//			1. 원글의 repStep + 1..
//			2. repRoot 값이 같은 다른 답글이 있는지 확인...
//			3. 원글의 repStep 값보다 큰 repStep값을 갖고 있는 답글의 repStep값을 변경 repStep+1
			// 트랜잭션 상황...

			pstmt.setInt(1, num);
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			
//			해당 답글의 repRoot : 1 .원글의 repRoot값을 그대로 넘겨받음...
			pstmt.setInt(5, orgDTO.getRepRoot() );
//			1. 원글의 repStep + 1..
			
			// 2, 3 번은 stepPlus1(conn, orgDTO);에서 진행할것임...
//			2. repRoot 값이 같은 다른 답글이 있는지 확인...
//			3. 원글의 repStep 값보다 큰 repStep값을 갖고 있는 답글의 repStep값을 변경 repStep+1			
			pstmt.setInt(6, orgDTO.getRepStep()+1);
			pstmt.setInt(7, orgDTO.getRepIndent()+1);
			
			pstmt.executeUpdate();
			
			isOk = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (isOk) {
					conn.commit();
				} else {
					conn.rollback();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			closeAll(null, pstmt, conn);
		}
		
	}



	private void stepPlus1(Connection conn, BoardDTO orgDTO) {
		PreparedStatement pstmt = null;

//		2. repRoot 값이 같은 다른 답글이 있는지 확인...
//		3. 원글의 repStep 값보다 큰 repStep값을 갖고 있는 답글의 repStep값을 변경 repStep+1

		String sql = "update board set repStep = repStep + 1 where repRoot = ? and repStep > ?";
//		1번에 부모의 repRoot값, 2번에 부모의 repStep을 가져올것이다...
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			System.out.println(123);
			pstmt.setInt(1, orgDTO.getRepRoot());
			pstmt.setInt(2, orgDTO.getRepStep());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);	// 트랜잭션 상황...conn...null로 해야한다.
		}
		
	}



	
	
	



	

}
