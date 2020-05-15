package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {
	//��κ� ����� ó��
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";	//full package��
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "ca2";	// id�� �빮�ڿ��� ������.
	private final String PASSWORD = "ca2"; 	// password �� ������ �ҹ���.
	
	// ���� ����Ʈ �����ڿ�  driver�� �����.
	public TestDAO() {
		try {	// forName()���� ����̹��� �����.
			Class.forName(DRIVERNAME);	// �޸𸮿� �ö󰣴ٴ� �ǹ�
			System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();  // ���� �߻��� ������ ������ �׻� �־��ش�...
		}	
	}
	
	// pstmt.executeUpdate();=========> select �� �����ϴ°� �ƴϸ� ������
	// pstmt.executeQuery();==========> select �� �����ϴ°��� ������
	
	
	
	// �Է�
	public void insert(MemberDTO dto) {
		Connection conn = null;		// Ŀ���� ����... �׸��� ������ �ݾ��־���Ѵ�.
		PreparedStatement pstmt = null;		// ���� pstmt�� ����
		String sql = "INSERT INTO tbl_member (id, name, age) values (?, ?, ?)";	//���ʺ��� ù��° ������ ? �ε����� 1�̴�.
		
		// �̰� �⺻Ʋ...try/catch ���� finally�ȿ� �ٽ� try/catch 
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Ŀ�ؼ� ���� ����");
			
			pstmt = conn.prepareStatement(sql);		// �����̿� �޴� ������°�...�ֹ��� �غ�
			
			// �ֹ��� �ۼ�
			pstmt.setString(1, dto.getId());	// sql������ values�� ������ ���� 
			pstmt.setString(2, dto.getName());	// 1���� id, 2���� name, 3���� age
			pstmt.setInt(3, dto.getAge());		// MemberDTO ��ü�� �޾ұ� ������ get���� �����;��Ѵ�.
			
			// �ֹ��� ������
			// pstmt.executeUpdate();=> select �� �����ϴ°� �ƴϸ� ������
			// pstmt.executeQuery();==> select �� �����ϴ°��� ������
			pstmt.executeUpdate();
		
		} catch (Exception e) {
			System.out.println("Ŀ�ؼ� ���� ����");
			e.printStackTrace();
		} finally {
			try {
				// Ŀ�ؼǺ��� ������Ʈ��Ʈ�� ���� ���ŵǾ���Ѵ�.���� �߿�
				if(pstmt !=null) {
					pstmt.close();
				}
				if(conn !=null) {	// conn�� ������ �������� conn�� �ݴ´�.
					conn.close();
				}		
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
	
	
	//Statement �� ������ �Ķ���ͷ� sql�� ����.
	// PreparedStatement�� �ȵ���.
	public List<MemberDTO> selectWhat(String what, String value){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		Statement stmt = null;		// Statement
		String sql = "";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.createStatement();	// Statement�� createStatement()���� �����.
			StringBuffer sb = new StringBuffer();
			
			// select * from tbl_member where what = value �� Ǯ�� ������ 
			// �Ϲ������� �̸� ���� ������
			sb.append("select * from tbl_member where ");
			sb.append(what);	//�÷��� 
			sb.append("='");	// sql������ ���ڻ��� ''�� ���ξ� �ϹǷ�... ' �����ش�.
			sb.append(value);
			sb.append("'");		// sql������ ���ڻ��� ''�� ���ξ� �ϹǷ�... ' �ݾ��ش�.
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				list.add(new MemberDTO(id, name, age));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs !=null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if( conn != null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return list;
	}
	
	
	// pstmt.executeUpdate();=> select �� �����ϴ°� �ƴϸ� ������
	// pstmt.executeQuery();==> select �� �����ϴ°��� ������
	public MemberDTO selectById(String id) {		//	id�� �˻��ϸ� ��ȯ���� �ϳ����̱� ������ ��ȯ���� MemberDTO�� �ص� �ȴ�.
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;		//PreparedStatement
		String sql= "SELECT * FROM tbl_member WHERE id=?";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("������ ���� ����");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			// pk�� �˻��ϴ°Ŷ� �ϳ����̴�. �׷��� while���ٴ� if���� �� ȿ����...
			
			while (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				list.add(new MemberDTO(id, name, age));
				
			}
			
			
		} catch (Exception e) {
			System.out.println("������ ���� ����");
			e.printStackTrace();
		} finally {
			try {
				if(rs !=null) {
					rs.close();
				}
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
		return dto;
	}
	
	
	
	
	// pstmt.executeUpdate();=> select �� �����ϴ°� �ƴϸ� ������
	// pstmt.executeQuery();==> select �� �����ϴ°��� ������
	public List<MemberDTO> selectByName(String name) {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;		//PreparedStatement
		String sql = "SELECT * FROM tbl_member WHERE name =?";
		
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Ŀ���� ���� ����");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			rs= pstmt.executeQuery();
			while (rs.next()) {
				 String id = rs.getString("id");
				 int age = rs.getInt("age");
				 
				 // name �� �Ķ���ͷ� �ޱ⶧����
				 MemberDTO dto = new MemberDTO(id, name, age);
				 list.add(dto);
				 
				 // list.add(new MemberDTO(id, name, age));
				 // �� ������ �ѹ���...
				
			}
		
			
		} catch (Exception e) {
			System.out.println("Ŀ���� ���� ����");
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) {
					rs.close();
				}
				if( pstmt !=null) {
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
	
	// ��ȸ
	// pstmt.executeUpdate();=> select �� �����ϴ°� �ƴϸ� ������
	// pstmt.executeQuery();==> select �� �����ϴ°��� ������
	public List<MemberDTO> selectAll() {
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;		//PreparedStatement
		String sql = "SELECT * FROM tbl_member ";	// ��Ī�� ������ �÷����� ��Ī�� �ȴ�.��Ī �켱...
		
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Ŀ�ؼ� ���� ����");
			
			pstmt = conn.prepareStatement(sql);
			
			// pstmt.executeUpdate();=> select �� �����ϴ°� �ƴϸ� ������
			// pstmt.executeQuery();==> select �� �����ϴ°��� ������
			 rs = pstmt.executeQuery();	// ���⸦ ��ġ�� rs�� null �� ��찡 ����.	
			 
			 while(rs.next()) {	
				 String id = rs.getString("id");	// ���̺� ������ �𸣴� �ε��� ���� ���� �÷������� ����.
				 int age = rs.getInt("age");		
				 String name = rs.getString("name");
				 MemberDTO dto = new MemberDTO(id, name, age);
				 list.add(dto);
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ŀ�ؼ� ���� ����");
		} finally {
			try {
				if(rs !=null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn !=null) {	// �޸� �Ҵ� �޾����� ���� �ȹ޾����� ��������
					conn.close();	// �������� ������ ������ �ݾ��־���Ѵ�. ���̱⶧��
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
	
	// ����
	public void update(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE tbl_member SET name = ?, age = ? WHERE id=?";	// ���ʺ��� ù��° ������ ? �ε����� 1�̴�.
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Ŀ���� ���� ����");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getId());
			
			// pstmt.executeUpdate();=> select �� �����ϴ°� �ƴϸ� ������
			// pstmt.executeQuery();==> select �� �����ϴ°��� ������
			pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			System.out.println("Ŀ���� ���� ����");
			e.printStackTrace();
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
	
	// ����
	// pstmt.executeUpdate();=> select �� �����ϴ°� �ƴϸ� ������
	// pstmt.executeQuery();==> select �� �����ϴ°��� ������
	public void delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM tbl_member WHERE id=?";
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Ŀ���� ���� ����");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			// pstmt.executeUpdate();=> select �� �����ϴ°� �ƴϸ� ������
			// pstmt.executeQuery();==> select �� �����ϴ°��� ������
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ŀ���� ���� ����");
		}finally {
			try {
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
		
				
		
	}
	
	
}
