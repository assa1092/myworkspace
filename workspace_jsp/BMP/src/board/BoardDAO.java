package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.BoardDTO;

public class BoardDAO {
private DataSource dataFactory;
	
	public BoardDAO() {
		
		try {
			Context	ctx = new InitialContext();
				
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
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



	public PageTO page(int curPage) {
		PageTO to = new PageTO(curPage);
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from ("
				+ "select rownum rnum, num, title, writer,writeday, readcnt, repIndent from("
				+ "select * from board order by repRoot desc, repStep asc)) "
				+ "where rnum>=? and rnum <=?";
		
		try {
			conn = dataFactory.getConnection();
			
			// DB에서 총개수 amount 값 가져와서...
			// 페이징 처리를 위한...to객체에 값을 알려준다...
			int amount = getAmount(conn);
			to.setAmount(amount);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, to.getStartNum());
			pstmt.setInt(2, to.getEndNum());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int repIndent = rs.getInt("repIndent");
				
				BoardDTO dto = new BoardDTO(num, writer, title, null, writeday, readcnt, -1, -1, repIndent);
				
				list.add(dto);
			}
			to.setList(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return to;
	}



	private int getAmount(Connection conn) {
		int amount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select count(num) from board";
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				amount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		
		return amount;
	}



	public void insert(BoardDTO boardDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql ="insert into board (num, writer, title, content, repRoot, repStep, repIndent) values(?,?,?,?,?,?,?)";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			int num = createNum(conn);
			
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
		Integer num = null;
		
		PreparedStatement pstmt = null;
		String sql="select max(num) from board";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				num = rs.getInt(1);
				
				num +=1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		String sql = "update board set readcnt = readcnt+1 where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}
		
		
	}

}
