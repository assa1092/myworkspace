package storage.com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import product.com.naver.ProductDTO;

public class StorageDAO {
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";

	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";

	private final String USERNAME = "ca2";

	private final String PASSWORD = "ca2";

	public StorageDAO() {
		try {
			Class.forName(DRIVERNAME);
			System.out.println("Driver Loading Success");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Fail");
			e.printStackTrace();
		}
	}

	// 삭제
	public void delete(String sid) {
		Connection conn = null;
		// 삭제하기 위해선 mid를 null로 바꿔주어야 하므로 2개의 요청을 한다.
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		// 먼저 삭제하려는 창고의 mid를 null로 바꾸기
		String sql1 = "update tbl_storage set mid = null where sid = ?";
		// 삭제되는 창고의 sid를 가지고 있는 물품의 sid값 null로 바꿔주기
		String sql2 = "update tbl_product set sid = null where sid = ?";
		boolean update = false;
		// 바꾼 후 삭제하기
		String sql3 = "delete from tbl_storage where sid = ?";

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// sql1 실행
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, sid);
			pstmt1.executeUpdate();
			pstmt1.close();
			// sql2 실행
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, sid);
			pstmt2.executeUpdate();
			pstmt2.close();
			update = true;
			// tbl_storage의 mid, tbl_product의 sid를 null로 바꾸어 주었다면 삭제 실행
			if (update) {
				// sql3 실행
				pstmt3 = conn.prepareStatement(sql3);
				pstmt3.setString(1, sid);
				pstmt3.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt2 != null) {
					pstmt2.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// 수정
	public void update(StorageDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update tbl_storage set location = ?, stype = ?, mid = ? where sid = ?";

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getLocation());
			pstmt.setString(2, dto.getStype());
			pstmt.setString(3, dto.getMid());
			pstmt.setString(4, dto.getSid());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// mid조회
	public boolean selectMid(String mid) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT mid FROM tbl_manager WHERE mid = ?";
		boolean isSid = false;
		boolean isOk = false;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 성공");
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				isSid = true;
			}
			isOk = true;
		} catch (Exception e) {
			System.out.println("커넥션 실패");
			e.printStackTrace();
		} finally {
			try {
				if (isOk) {
					conn.commit();
				} else {
					conn.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return isSid;
	}

	public List<StorageDTO> selectAll() {
		List<StorageDTO> list = new ArrayList<StorageDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from tbl_storage";
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String sid = rs.getString("sid");
				String location = rs.getString("location");
				String stype = rs.getString("stype");
				String mid = rs.getString("mid");

				StorageDTO dto = new StorageDTO(sid, location, stype, mid);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}

	public void insert(StorageDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into tbl_storage (sid, location, stype, mid) values (?, ?, ?, ?)";

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getSid());
			pstmt.setString(2, dto.getLocation());
			pstmt.setString(3, dto.getStype());
			pstmt.setString(4, dto.getMid());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
