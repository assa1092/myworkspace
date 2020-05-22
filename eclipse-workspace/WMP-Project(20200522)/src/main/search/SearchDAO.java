package main.search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import main.search.WmpDTO;
import manager.com.naver.ManagerDTO;
import product.com.naver.ProductDTO;
import storage.com.naver.StorageDTO;

public class SearchDAO {
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "ca2";
	private final String PASSWORD = "ca2";

	public SearchDAO() {
		try {
			Class.forName(DRIVERNAME);
			System.out.println("드라이버 연결 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이버 연결 실패");
		}
	}

	public List<WmpDTO> searchByPName(String pname) {

		List<WmpDTO> plist = new ArrayList<WmpDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select p.pname, s.stype, s.location, p.amount, p.price , p.discount\r\n"
				+ "from tbl_storage s, tbl_product p \r\n" + "WHERE p.pname like '%'||?||'%' and s.sid = p.sid";

		boolean isOk = false;

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 성공");
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pname);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String pname1 = rs.getString("pname");
				String stype1 = rs.getString("stype");
				String location = rs.getString("location");
				int amount = rs.getInt("amount");
				int price = rs.getInt("price");
				int discount = rs.getInt("discount");

				WmpDTO pdto = new WmpDTO(pname1, stype1, location, amount, price, discount);
				plist.add(pdto);
			}
			isOk = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("커넥션 실패");
			e.printStackTrace();
		} finally {
			try {
				try {
					if (isOk) {
						conn.commit();
					} else {
						conn.rollback();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return plist;
	}

	// 물품 종류로 검색 like 사용
	public List<WmpDTO> searchByStype(String stype) {
		List<WmpDTO> wlist = new ArrayList<WmpDTO>();

		WmpDTO wdto = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select *\r\n" + "from tbl_manager m , tbl_storage s , tbl_product p\r\n"
				+ "WHERE s.stype like '%'||?||'%' and s.sid = p.sid and s.mid = m.mid";

		boolean isOk = false;

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 성공");
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, stype);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String mname = rs.getString("mname");
				String mid = rs.getString("mid");
				String dept = rs.getString("dept");

				String sid = rs.getString("sid");
				String location = rs.getString("location");
				String stype1 = rs.getString("stype");

				String pid = rs.getString("pid");
				String pname = rs.getString("pname");
				int amount = rs.getInt("amount");
				int price = rs.getInt("price");
				int discount = rs.getInt("discount");

				wdto = new WmpDTO(mid, mname, dept, pid, pname, amount, price, discount, sid, location, stype1);
				wlist.add(wdto);

			}

			isOk = true;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("커넥션 실패");
			e.printStackTrace();
		} finally {
			try {
				try {
					if (isOk) {
						conn.commit();
					} else {
						conn.rollback();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return wlist;

	}

	// 관리자 명으로 검색 like %?%
	public List<WmpDTO> searchByMname(String mname) {

		List<WmpDTO> wlist = new ArrayList<WmpDTO>();

		WmpDTO wdto = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select *\r\n" + "from tbl_manager m , tbl_storage s , tbl_product p\r\n"
				+ "WHERE m.mname like '%'||?||'%'";

		boolean isOk = false;

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 성공");
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mname);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String mname1 = rs.getString("mname");
				String mid = rs.getString("mid");
				String dept = rs.getString("dept");

				String sid = rs.getString("sid");
				String location = rs.getString("location");
				String stype = rs.getString("stype");

				String pid = rs.getString("pid");
				String pname = rs.getString("pname");
				int amount = rs.getInt("amount");
				int price = rs.getInt("price");
				int discount = rs.getInt("discount");

				wdto = new WmpDTO(mid, mname1, dept, pid, pname, amount, price, discount, sid, location, stype);
				wlist.add(wdto);

			}

			isOk = true;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("커넥션 실패");
			e.printStackTrace();
		} finally {
			try {
				try {
					if (isOk) {
						conn.commit();
					} else {
						conn.rollback();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return wlist;

	}

	public List<WmpDTO> searchById(String mid) {

		List<WmpDTO> wlist = new ArrayList<WmpDTO>();

		WmpDTO wdto = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select m.mid, m.mname, m.dept, s.sid, s.location, s.stype, p.pid, p.pname, p.amount, p.price, p.discount \r\n"
				+ "from tbl_manager m , tbl_storage s , tbl_product p \r\n"
				+ "WHERE m.mid = ? and m.mid =  s.mid and s.sid = p.sid";

		boolean isOk = false;

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 성공");
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mid);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				String mname = rs.getString("mname");
				String dept = rs.getString("dept");

				String sid = rs.getString("sid");
				String location = rs.getString("location");
				String stype = rs.getString("stype");

				String pid = rs.getString("pid");
				String pname = rs.getString("pname");
				int amount = rs.getInt("amount");
				int price = rs.getInt("price");
				int discount = rs.getInt("discount");

				wdto = new WmpDTO(mid, mname, dept, pid, pname, amount, price, discount, sid, location, stype);
				wlist.add(wdto);

			}

			isOk = true;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("커넥션 실패");
			e.printStackTrace();
		} finally {
			try {
				try {
					if (isOk) {
						conn.commit();
					} else {
						conn.rollback();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return wlist;
	}

}
