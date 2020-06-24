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

	
	

	


}
