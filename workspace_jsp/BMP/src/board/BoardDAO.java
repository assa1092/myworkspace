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

}
