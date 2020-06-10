package review.dao;

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

import review.domain.ReviewDTO;

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

	// close() 메소드
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
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
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// 전체 조회
	public List<ReviewDTO> list() {
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM review ORDER BY num desc";
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				String category = rs.getString("category");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int starpoint = rs.getInt("starpoint");
				list.add(new ReviewDTO(num, title, content, id, category, writeday, readcnt, starpoint));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	}

	// 상세조회
	public ReviewDTO read(int num) {
		ReviewDTO list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM review WHERE num = ?";
		boolean isOk = false;

		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
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
				list = new ReviewDTO(num, title, content, id, category, writeday, readcnt, starpoint);
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
		return list;
	}

	// 조회수 증가
	private void increaseReadCnt(Connection conn, int num) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE review SET readcnt = readcnt + 1 WHERE num = ?";
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

	// 추가
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

	// insert에 필요한 num값 생성
	private int createNum(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = "select max(num) from review";
		ResultSet rs = null;
		Integer num = null;
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

	// 게시물 삭제
	public void delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from review where num = ?";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
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

				dto = new ReviewDTO(num, title, content, id, category, null, 0, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return dto;
	}

	// 게시물 수정
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
}
