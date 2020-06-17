package com.naver;

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

public class BoardDAO {
	private DataSource dataFactory;
	
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
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
		String sql = "SELECT * FROM board order by repRoot desc, repStep asc";
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
		String sql = "INSERT INTO board (num, writer, title, content, repRoot, repStep, repIndent) values(?,?,?,?,?,?,?)";
		
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
		PreparedStatement pstmt = null;
		
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
				
				list.add(new BoardDTO(num, writer, title, null, writeday, readcnt, -1, -1, repIndent));
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
		String sql = "select * from board where num=?";
		ResultSet rs = null;
		
		boolean isOk = false;
		
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			
			increaseReadCnt(conn, num);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				
				dto = new BoardDTO(num, writer, title, content, writeday, readcnt, 0, 0, 0);
				
				isOk = true;
			}
			
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

	public BoardDTO updateUI(int num) {
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
}
