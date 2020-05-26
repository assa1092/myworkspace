package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// �ϳ��� ���̺��� ���� DAO�ϳ���...
// DAO Db�� ��������Ǵ� Ŭ����
public class MemberDAO {
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "ca2";	
	private final String PASSWORD = "ca2";
	
	public MemberDAO() {
		try {
			Class.forName(DRIVERNAME);
			System.out.println("driver loading success");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("driver loading fail");
		}
	}
	
	
	public void delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from tbl_member where id =? ";
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	
	public void update(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update tbl_member set name = ?, age=? WHERE id = ?";
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);		// �ֹ��� �غ�
			
			pstmt.setString(1, dto.getName());		// �ֹ��� �ۼ�
			pstmt.setInt(2, dto.getAge());			// �ֹ��� �ۼ�
			pstmt.setString(3, dto.getId());		// �ֹ��� �ۼ�
			
			pstmt.executeUpdate();					// �ֹ��� ����...
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt !=null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	public List<MemberDTO> selectByName(String name){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from tbl_member WHERE name=?";
		
		try {
			conn =  DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Ŀ���� ���� ����");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				int age = rs.getInt("age");
				
				MemberDTO dto = new MemberDTO(id, name, age);
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Ŀ���� ���� ����");
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
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		
		return list;
		
	}
	
	public MemberDTO selectById(String id) {
		MemberDTO dto = null;
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from tbl_member WHERE id=?";
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Ŀ���� ���� ����");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
	
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				//list.add(new MemberDTO(id, name, age));
				dto = new MemberDTO(id, name, age);
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Ŀ���� ���� ����");
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
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		
		return dto;
	}
	
	
	
	
	
	// select ��ȸ�� ������ ��ȯ���� �־�� �Ѵ�. 
	// ��ȯ��ü ����� �ٷ� return list; �ٷ� �Ѽ�Ʈ�� �ۼ��ϰ� ����...
	public List<MemberDTO> selectAll(){
		List<MemberDTO> list =  new ArrayList<MemberDTO>();
		
		Connection conn = null;					// ����
		PreparedStatement pstmt = null;			// ����
		String sql = "select * from tbl_member";
		ResultSet rs = null;		// select ������ ���� ����� �޾ƿ� ��ü ����...���...
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id  = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				// int age = rs.getInt(3);		// �÷��� �˰��ֱ⶧���� 3���ε� �Ҽ��ִ�...
				
				MemberDTO dto =  new MemberDTO(id, name, age);
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return list;
	}
	
	
	
	public void insert(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="insert into tbl_member (id, name, age) values (?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Ŀ�ؼ� ���� ����");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			
			// insert�� .executeUpdate();
			// select�� .executeQuery();
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ŀ�ؼ� ���� ����");
		}finally {
			try {
				if(pstmt !=null) {
					pstmt.close();
				}
				if(conn !=null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
}