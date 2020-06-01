package com.naver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 아이디와 패스워드까지 맞아야 수정 가능...
		String sql = "UPDATE member SET name=?, age=? WHERE id= ? and pw=?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getId());
			pstmt.setString(4, dto.getPassword());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
		
	}
	
	
	public MemberDTO selectById(String id) {
		MemberDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM member WHERE id=?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				dto = new MemberDTO(id, name, age, null);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return dto;
	}
	
	public void insert(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member (id, name, age, pw) VALUES (?, ?, ?, ?)";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getPassword());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}
	
	public List<MemberDTO> selectAll(){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM member ORDER BY id asc";
		ResultSet rs = null;
		
		try {
			
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			// 물음표가 없으니 바로 쿼리 날린다...
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name= rs.getString("name");
				int age = rs.getInt("age");
				
				// 비밀번호는 안보이게...
				list.add(new MemberDTO(id, name, age, null));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return list;
	}

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
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}


	public MemberDTO updateUI(String id) {
		// TODO Auto-generated method stub
		return selectById(id);
	}

	public boolean login(LoginDTO loginDTO) {
		boolean isLogin = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM member WHERE id=? and pw=?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginDTO.getId());
			pstmt.setString(2, loginDTO.getPw());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				isLogin = true;
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return isLogin;
	}

	public void delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM member WHERE id=?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	
}
