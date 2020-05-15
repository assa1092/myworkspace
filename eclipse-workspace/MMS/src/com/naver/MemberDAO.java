package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 하나의 테이블당 보통 DAO하나씩...
// DAO Db와 직접연결되는 클래스
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
			pstmt = conn.prepareStatement(sql);		// 주문서 준비
			
			pstmt.setString(1, dto.getName());		// 주문서 작성
			pstmt.setInt(2, dto.getAge());			// 주문서 작성
			pstmt.setString(3, dto.getId());		// 주문서 작성
			
			pstmt.executeUpdate();					// 주문서 제출...
			
			
			
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
	
	
	// select 조회는 무조건 반환값이 있어야 한다. 
	// 반환객체 만들고 바로 return list; 바로 한세트로 작성하고 시작...
	public List<MemberDTO> selectAll(){
		List<MemberDTO> list =  new ArrayList<MemberDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from tbl_member";
		ResultSet rs = null;		// select 쿼리의 실행 결과를 받아올 객체 생성...
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id  = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				// int age = rs.getInt(3);		// 컬럼을 알고있기때문에 3으로도 할수있다...
				
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
			System.out.println("커넥션 연결 성공");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			
			// insert라 .executeUpdate();
			// select면 .executeQuery();
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("커넥션 연결 실패");
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
