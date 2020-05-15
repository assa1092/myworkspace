package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {
	//대부분 상수로 처리
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";	//full package명
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "ca2";	// id는 대문자여도 괜찮다.
	private final String PASSWORD = "ca2"; 	// password 는 무조건 소문자.
	
	// 보통 디폴트 생성자에  driver를 만든다.
	public TestDAO() {
		try {	// forName()으로 드라이버를 만든다.
			Class.forName(DRIVERNAME);	// 메모리에 올라간다는 의미
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();  // 예외 발생시 나오는 문구는 항상 넣어준다...
		}	
	}
	
	// pstmt.executeUpdate();=========> select 로 시작하는게 아니면 무조건
	// pstmt.executeQuery();==========> select 로 시작하는것은 무조건
	
	
	
	// 입력
	public void insert(MemberDTO dto) {
		Connection conn = null;		// 커낵션 선언... 그리고 무조건 닫아주어야한다.
		PreparedStatement pstmt = null;		// 보통 pstmt로 선언
		String sql = "INSERT INTO tbl_member (id, name, age) values (?, ?, ?)";	//왼쪽부터 첫번째 만나는 ? 인덱스가 1이다.
		
		// 이게 기본틀...try/catch 다음 finally안에 다시 try/catch 
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 연결 성공");
			
			pstmt = conn.prepareStatement(sql);		// 빈종이에 메뉴 적어놓는것...주문서 준비
			
			// 주문서 작성
			pstmt.setString(1, dto.getId());	// sql문에서 values값 순서에 따라서 
			pstmt.setString(2, dto.getName());	// 1번은 id, 2번은 name, 3번은 age
			pstmt.setInt(3, dto.getAge());		// MemberDTO 객체로 받았기 때문에 get으로 가져와야한다.
			
			// 주문서 보내기
			// pstmt.executeUpdate();=> select 로 시작하는게 아니면 무조건
			// pstmt.executeQuery();==> select 로 시작하는것은 무조건
			pstmt.executeUpdate();
		
		} catch (Exception e) {
			System.out.println("커넥션 연결 실패");
			e.printStackTrace();
		} finally {
			try {
				// 커넥션보다 스테이트먼트가 먼저 제거되어야한다.순서 중요
				if(pstmt !=null) {
					pstmt.close();
				}
				if(conn !=null) {	// conn의 연결이 끊어지면 conn을 닫는다.
					conn.close();
				}		
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
	
	
	//Statement 문 쓸때만 파라미터로 sql이 들어간다.
	// PreparedStatement는 안들어간다.
	public List<MemberDTO> selectWhat(String what, String value){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		Statement stmt = null;		// Statement
		String sql = "";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.createStatement();	// Statement는 createStatement()으로 만든다.
			StringBuffer sb = new StringBuffer();
			
			// select * from tbl_member where what = value 를 풀어 놓은것 
			// 일반적으로 이리 쓰지 않지만
			sb.append("select * from tbl_member where ");
			sb.append(what);	//컬럼명 
			sb.append("='");	// sql에서는 숫자빼고 ''로 감싸야 하므로... ' 열어준다.
			sb.append(value);
			sb.append("'");		// sql에서는 숫자빼고 ''로 감싸야 하므로... ' 닫아준다.
			
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
	
	
	// pstmt.executeUpdate();=> select 로 시작하는게 아니면 무조건
	// pstmt.executeQuery();==> select 로 시작하는것은 무조건
	public MemberDTO selectById(String id) {		//	id로 검색하면 반환값이 하나뿐이기 때문에 반환값을 MemberDTO로 해도 된다.
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;		//PreparedStatement
		String sql= "SELECT * FROM tbl_member WHERE id=?";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("컨낵션 연결 성공");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			// pk로 검색하는거라 하나뿐이다. 그래서 while보다는 if문이 더 효율적...
			
			while (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				list.add(new MemberDTO(id, name, age));
				
			}
			
			
		} catch (Exception e) {
			System.out.println("컨낵션 연결 실패");
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
	
	
	
	
	// pstmt.executeUpdate();=> select 로 시작하는게 아니면 무조건
	// pstmt.executeQuery();==> select 로 시작하는것은 무조건
	public List<MemberDTO> selectByName(String name) {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;		//PreparedStatement
		String sql = "SELECT * FROM tbl_member WHERE name =?";
		
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커낵션 연결 성공");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			rs= pstmt.executeQuery();
			while (rs.next()) {
				 String id = rs.getString("id");
				 int age = rs.getInt("age");
				 
				 // name 은 파라미터로 받기때문에
				 MemberDTO dto = new MemberDTO(id, name, age);
				 list.add(dto);
				 
				 // list.add(new MemberDTO(id, name, age));
				 // 위 두줄을 한번에...
				
			}
		
			
		} catch (Exception e) {
			System.out.println("커낵션 연결 실패");
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
	
	// 조회
	// pstmt.executeUpdate();=> select 로 시작하는게 아니면 무조건
	// pstmt.executeQuery();==> select 로 시작하는것은 무조건
	public List<MemberDTO> selectAll() {
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;		//PreparedStatement
		String sql = "SELECT * FROM tbl_member ";	// 별칭이 없으면 컬럼명이 별칭이 된다.별칭 우선...
		
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 연결 성공");
			
			pstmt = conn.prepareStatement(sql);
			
			// pstmt.executeUpdate();=> select 로 시작하는게 아니면 무조건
			// pstmt.executeQuery();==> select 로 시작하는것은 무조건
			 rs = pstmt.executeQuery();	// 여기를 거치면 rs가 null 일 경우가 없다.	
			 
			 while(rs.next()) {	
				 String id = rs.getString("id");	// 테이블 순서를 모르니 인덱스 말고 보통 컬럼명으로 쓴다.
				 int age = rs.getInt("age");		
				 String name = rs.getString("name");
				 MemberDTO dto = new MemberDTO(id, name, age);
				 list.add(dto);
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("커넥션 연결 실패");
		} finally {
			try {
				if(rs !=null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn !=null) {	// 메모리 할당 받았으면 연결 안받았으면 연결해제
					conn.close();	// 지역변수 이지만 무조건 닫아주어야한다. 무겁기때문
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
	
	// 수정
	public void update(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE tbl_member SET name = ?, age = ? WHERE id=?";	// 왼쪽부터 첫번째 만나는 ? 인덱스가 1이다.
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커낵션 연결 성공");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getId());
			
			// pstmt.executeUpdate();=> select 로 시작하는게 아니면 무조건
			// pstmt.executeQuery();==> select 로 시작하는것은 무조건
			pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			System.out.println("커낵션 연결 실패");
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
	
	// 삭제
	// pstmt.executeUpdate();=> select 로 시작하는게 아니면 무조건
	// pstmt.executeQuery();==> select 로 시작하는것은 무조건
	public void delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM tbl_member WHERE id=?";
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커낵션 연결 성공");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			// pstmt.executeUpdate();=> select 로 시작하는게 아니면 무조건
			// pstmt.executeQuery();==> select 로 시작하는것은 무조건
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("커낵션 연결 실패");
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
