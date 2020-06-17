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
			
			e.printStackTrace();
		}
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn){
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
			e.printStackTrace();
		}
	}

	public List<MemberDTO> selectAll() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM member ORDER BY id asc";
		ResultSet rs = null;
		
		try {
			
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name= rs.getString("name");
				String property = rs.getString("property");
				
				
				list.add(new MemberDTO(id, name, null, property));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return list;
	}

	public void insert(MemberDTO memberDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member (id, name, pw, property) VALUES (?, ?, ?, ?)";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberDTO.getId());
			pstmt.setString(2, memberDTO.getName());
			pstmt.setString(3, memberDTO.getPassword());
			pstmt.setString(4, memberDTO.getProperty());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
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
				String property = rs.getString("property");
				
				dto = new MemberDTO(id, name, null, property);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return dto;
	}

	public MemberDTO updateUI(String id) {
		
		return selectById(id);
	}

	public void update(MemberDTO memberDTO) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 아이디와 패스워드까지 맞아야 수정 가능...
		String sql = "UPDATE member SET name=?, property=? WHERE id= ? and pw=?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getProperty());
			pstmt.setString(3, memberDTO.getId());
			pstmt.setString(4, memberDTO.getPassword());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
		
	}

	public boolean login(LoginDTO loginDTO) {
		boolean isLogin = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member where id=? and pw=?";
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
