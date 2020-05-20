package product.com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "ca2";
	private final String PASSWORD = "ca2";

	public ProductDAO() {
		try {
			Class.forName(DRIVERNAME);
			System.out.println("드라이버 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 실패");
			e.printStackTrace();
		}
	}

	// 삭제
	public void delete(String pid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM tbl_product WHERE pid = ?";
		boolean isOk = false;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 성공");
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pid);
			pstmt.executeUpdate();
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

	// 수정
	public void update(ProductDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE tbl_product SET pname = ?, amount = ?, price = ?, discount = ?, sid = ? WHERE pid = ?";
		boolean isOk = false;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 성공");
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPname());
			pstmt.setInt(2, dto.getAmount());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setInt(4, dto.getDiscount());
			pstmt.setString(5, dto.getSid());
			pstmt.setString(6, dto.getPid());
			pstmt.executeUpdate();
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

	// 조회
	public List<ProductDTO> selectAll() {
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tbl_product";
		boolean isOk = false;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 성공");
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String pid = rs.getString("pid");
				String pname = rs.getString("pname");
				int amount = rs.getInt("amount");
				int price = rs.getInt("price");
				int discount = rs.getInt("discount");
				String sid = rs.getString("sid");

				list.add(new ProductDTO(pid, pname, amount, price, discount, sid));
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
		return list;
	}

	// 입력
	public void insert(ProductDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO tbl_product (pid, pname, amount, price, discount, sid) VALUES (?, ?, ?, ?, ?, ?) ";
		boolean isOk = false;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 성공");
			// 트랜잭션을 위한 오토커밋 해제
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPid());
			pstmt.setString(2, dto.getPname());
			pstmt.setInt(3, dto.getAmount());
			pstmt.setInt(4, dto.getPrice());
			pstmt.setInt(5, dto.getDiscount());
			pstmt.setString(6, dto.getSid());
			pstmt.executeUpdate();

			// 트랜잭션을 위한 isOk 값 설정
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
