package review;

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

import review.ReviewDTO;

public class ReviewDAO {
	private DataSource dataFactory;
	
	public ReviewDAO() {
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

	public PageTO page(int curPage) {
		PageTO to = new PageTO(curPage);
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from ("
				+ "select rownum rnum, num, title, id, category, writeday, readcnt, starpoint from ("
				+ "select * from review order by num desc)) " 
				+ "where rnum>=? and rnum<=?";;
		try {
			conn = dataFactory.getConnection();
			int amount = getAmount(conn);		// 게시판 글 총개수 알아오기
			to.setAmount(amount);				// 알아온 총개수 페이지처리하는곳에 알려주기.
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, to.getStartNum());
			pstmt.setInt(2, to.getEndNum());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String id = rs.getString("id");
				String category = rs.getString("category");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int starpoint = rs.getInt("starpoint");
				
				list.add(new ReviewDTO(num, title, null, id, category, writeday, readcnt, starpoint));
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
		String sql = "select count(num) from review";
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

	public ReviewDTO notice() {

		ReviewDTO list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT * FROM review WHERE id = 'admin' ORDER BY num desc) WHERE ROWNUM = 1";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String category = rs.getString("category");
				String writeday = rs.getString("writeday");
				String id = rs.getString("id");
				int readcnt = rs.getInt("readcnt");
				int starpoint = rs.getInt("starpoint");

				list = new ReviewDTO(num, title, content, id, category, writeday, readcnt, starpoint);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	
	}

	public ReviewDTO read(int num) {
		ReviewDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from review where num=?";
		ResultSet rs = null;
		boolean isOk = false;
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			// 조회하면 조회수 증가...
			increaseReadCnt(conn, num);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				String category = rs.getString("category");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int starpoint = rs.getInt("starpoint");
				dto = new ReviewDTO(num, title, content, id, category, writeday, readcnt, starpoint);
				
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
		String sql = "update review set readcnt = readcnt +1 where num=?";
		
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

	public ReviewDTO updateUI(int num) {
		ReviewDTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM review WHERE num=?";
		ResultSet rs = null;

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				String category = rs.getString("category");
				int starpoint = rs.getInt("starpoint");

				dto = new ReviewDTO(num, title, content, id, category, null, 0, starpoint);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return dto;
	}

	public void update(ReviewDTO reviewDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE review SET title=?, category=?, starpoint=?, content=? WHERE num=?";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, reviewDTO.getTitle());
			pstmt.setString(2, reviewDTO.getCategory());
			pstmt.setInt(3, reviewDTO.getStarpoint());
			pstmt.setString(4, reviewDTO.getContent());
			pstmt.setInt(5, reviewDTO.getNum());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	public void insert(ReviewDTO reviewDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into review (num, title, content, id, category, starpoint) values (?, ?, ?, ?, ?, ?)";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			int num = createNum(conn);

			pstmt.setInt(1, num);
			pstmt.setString(2, reviewDTO.getTitle());
			pstmt.setString(3, reviewDTO.getContent());
			pstmt.setString(4, reviewDTO.getId());
			pstmt.setString(5, reviewDTO.getCategory());
			pstmt.setInt(6, reviewDTO.getStarpoint());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}

	private int createNum(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = "select max(num) from review";
		ResultSet rs = null;
		Integer num = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt(1);
				num += 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		return num;
	}

	public PageTO catepage(int curPage, String category) {
		PageTO to =  new PageTO(curPage);
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from ("
					+ "select rownum rnum, num, title, id, category,writeday, readcnt, starpoint from ("
					+ "select * from review where category=? order by num desc)) "
					+ "where rnum >=? and rnum<= ?";
		
		try {
			conn = dataFactory.getConnection();
			int amount = getCateAmount(conn, category);
			to.setAmount(amount);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setInt(2, to.getStartNum());
			pstmt.setInt(3, to.getEndNum());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String id = rs.getString("id");

				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int starpoint = rs.getInt("starpoint");
				
				ReviewDTO dto = new ReviewDTO(num, title, null, id, category, writeday, readcnt, starpoint);
				
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

	private int getCateAmount(Connection conn, String category) {
		int amount =0;
		PreparedStatement pstmt = null;
		String sql = "select count(num) from review where category=?";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, category);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
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
