package board.dao;

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

import board.domain.BoardDTO;
import board.domain.PageTO;
import board.domain.UploadDTO;


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

	public PageTO page(int curPage) {
		PageTO to = new PageTO(curPage);
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from ("
				+ "select rownum rnum, num, title, writer, writeday, readcnt, repIndent from ("
				+ "select * from board order by repRoot desc, repStep asc)) "
				+ "where rnum >=? and rnum <= ?";
		
		try {
			conn = dataFactory.getConnection();
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
				
				BoardDTO dto =  new BoardDTO(num, writer, title, null, writeday, readcnt, -1, -1, repIndent);
				
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
		String sql = "select count(num) from board";
		ResultSet rs = null;
		
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

	public BoardDTO read(int num) {
		BoardDTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from board where num=?";
		boolean isOk =false;
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			
			increaseReadCnt(conn, num);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
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
				
			}
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

	public UploadDTO imgSelect(int num) {
		UploadDTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select fileName, orgFileName from boardupload where num = ?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String fileName = rs.getString("fileName");
				String orgFileName = rs.getString("orgFileName");
				
				dto = new UploadDTO(fileName, orgFileName, num);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return dto;
	}

	public void insert(BoardDTO boardDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board (num, writer, title, content, repRoot,repStep, repIndent) values (?,?,?,?,?,?,?)";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			int num = createNum(conn);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, boardDTO.getWriter());
			pstmt.setString(3, boardDTO.getTitle());
			pstmt.setString(4, boardDTO.getContent());
			pstmt.setInt(5, num);
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
		int num = 0;
		PreparedStatement pstmt = null;
		String sql = "select max(num) from board";
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

	public void insert(BoardDTO boardDTO, UploadDTO uploadDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board (num, writer, title, content, repRoot, repStep, repIndent) values (?,?,?,?,?,?,?)";
		
		boolean isOk = false;
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			
			int num = createNum(conn);
			
			upload(conn, new UploadDTO(uploadDTO.getFileName(), uploadDTO.getOrgFileName(), num));
			
			pstmt.setInt(1, num);
			pstmt.setString(2, boardDTO.getWriter());
			pstmt.setString(3, boardDTO.getTitle());
			pstmt.setString(4, boardDTO.getContent());
			pstmt.setInt(5, num);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			
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

	private void upload(Connection conn, UploadDTO uploadDTO) {
		PreparedStatement pstmt = null;
		String sql = "insert into boardupload (num, fileName, orgFileName) values (?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, uploadDTO.getNum());
			pstmt.setString(2, uploadDTO.getFileName());
			pstmt.setString(3, uploadDTO.getOrgFileName());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}
		
	}

	public void reply(int orgNum, BoardDTO dto, UploadDTO uploadDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board (num, writer, title, content, repRoot, repStep, repIndent) values (?,?,?,?,?,?,?)";
		
		boolean isOk = false;
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);		// 트랜잭션 처리해줄려면 무조건 setAutoCommit 을 false 로....디폴트는 true
			
			int num = createNum(conn);	// 부모(원글)의 num값 가져오기...
			
			upload(conn, new UploadDTO(uploadDTO.getFileName(), uploadDTO.getOrgFileName(), num));
			
			// 부모의 num 값...orgnum 
			BoardDTO orgDTO = updateUI(orgNum);	// 부모글의 DTO...repRoot, repStep, repIndent 다 있다...
			
			// 커낵션이 달라지면 트랜잭션이 발생하지 않는다...
			stepPlus1(conn, orgDTO);
						
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
			
			pstmt.setInt(1, orgDTO.getRepRoot());
			pstmt.setInt(2, orgDTO.getRepStep());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);	// 트랜잭션 상황...conn...null로 해야한다.
		}
		
		
	}
	
// 조회수 증가없이 부모의 repRoot, repStep, repIndent 값 가져오기
	public BoardDTO updateUI(int orgNum) {
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
			
			pstmt.setInt(1, orgNum);
			
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

				dto = new BoardDTO(orgNum, writer, title, content, null, 0, repRoot, repStep, repIndent);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return dto;
	}

	public void update(BoardDTO dto, UploadDTO uploadDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update board set writer=?, title=?, content=? where num=?";
		
		boolean isOk = false;
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			
			// 기존의 파일이 존재할 시 삭제
			if(uploadDTO.getFileName()!=null) {
				uploadDelete(conn, dto.getNum());
				// 새로운 파일 업로드
				upload(conn, new UploadDTO(uploadDTO.getFileName(), uploadDTO.getOrgFileName(), dto.getNum()));
			}
			
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getNum());
			
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

	// 게시물 삭제 시 해당 num값의 upload 행 삭제
	private void uploadDelete(Connection conn, int num) {
		PreparedStatement pstmt = null;
		String sql = "delete from boardupload where num = ?";

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

	public void delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from board where num = ?";
		boolean isOk = false;

		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			uploadDelete(conn, num);
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			closeAll(null, pstmt, conn);
		}
	}

	public List<BoardDTO> searchByTitle(String search) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board WHERE title like '%'||?||'%'";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, search);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				

				list.add(new BoardDTO(num, writer, title, content, writeday, readcnt, 0, 0, 0));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return list;
	}

	public List<BoardDTO> searchByWriter(String search) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board WHERE writer like '%'||?||'%'";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, search);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				int readcnt = rs.getInt("readcnt");
				String writeday = rs.getString("writeday");
				

				list.add(new BoardDTO(num, writer, title, content, writeday, readcnt, 0, 0, 0));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return list;
	}

	public List<BoardDTO> searchByTitleContent(String search) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board WHERE (title like '%'||?||'%') or (content like '%'||?||'%')";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, search);
			pstmt.setString(2, search);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				int readcnt = rs.getInt("readcnt");
				String writeday = rs.getString("writeday");
				

				list.add(new BoardDTO(num, writer, title, content, writeday, readcnt, 0, 0, 0));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return list;
	}

	
	


}
