package manager.com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDAO {
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "ca2";
	private final String PASSWORD = "ca2";
	
	public ManagerDAO() {
		try {
			Class.forName(DRIVERNAME);
			System.out.println("드라이버 연결 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이버 연결 실패");
		}
	}
	// ���� 
	public void delete(String mid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from tbl_manager WHERE id=?";
		
		boolean isOk = false;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 성공");
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mid);
						
			pstmt.executeUpdate();
			
			isOk = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("커넥션 실패");
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
			
			try {
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
		
		
	}
	
	// ����.
	public void update(ManagerDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update tbl_manager set mname =?, dept = ? WHERE mid = ?";
		
		boolean isOk = false;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 성공");
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getMname());
			pstmt.setString(2, dto.getDept());
			pstmt.setString(3, dto.getMid());
			
			pstmt.executeUpdate();
			
			isOk = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("커넥션 실패");
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
			
			try {
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
		
		
	}
	
	// ��ü ��ȸ
	public List<ManagerDTO> selectAll() {
		List<ManagerDTO> list = new ArrayList<ManagerDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from tbl_manager";
		ResultSet rs = null;
		
		boolean isOk = false;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 성공");
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String mid = rs.getString("mid");
				String mname = rs.getString("mname");
				String dept = rs.getString("dept");
				
				ManagerDTO dto = new ManagerDTO(mid, mname, dept);
				list.add(dto);
				
			}
						
			isOk = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("커넥션 실패");
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
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return list;
	}
	
	
	// ����.
	public void insert(ManagerDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into tbl_manager (mid, mname, dept) values(?, ?, ?)";
		
		boolean isOk = false;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn.setAutoCommit(false);
			
			System.out.println("커넥션 성공");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getMname());
			pstmt.setString(3, dto.getDept());
			
			pstmt.executeUpdate();
			
			
			isOk = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("커넥션 실패");
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
			
			
			
			try {
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
	}
	

}
