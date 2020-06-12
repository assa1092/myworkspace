package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import member.domain.MemberDTO;
import share.CommandAction;
import sun.security.provider.certpath.ResponderId;

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

		// TODO Auto-generated constructor stub
	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {

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
		}

	}

	public MemberDTO login(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select*from member where id =?";
		ResultSet rs = null;
		MemberDTO dto = null;

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String tpw = rs.getString("pw");

				if (tpw.equals(pw)) {
					System.out.println("pw 가 일치합니다.");
					String property = rs.getString("property");
					String name = rs.getString("name");

					dto = new MemberDTO(id, name, tpw, property);

				} else {

					dto = new MemberDTO("0", null, null, null);
				}
			} else {
				dto = new MemberDTO("0", null, null, null);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return dto;

	}

	public List<MemberDTO> selectAll() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member";
		ResultSet rs = null;

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");

				list.add(new MemberDTO(id, name, pw, null));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	}

	public void insert(MemberDTO mDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member (id, name, pw) values (?,?,?)";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDTO.getId());
			pstmt.setString(2, mDTO.getName());
			pstmt.setString(3, mDTO.getPw());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}

	public MemberDTO selectById(String id) {
		MemberDTO mDTO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member where id=?";
		ResultSet rs = null;

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String property = rs.getString("property");

				mDTO = new MemberDTO(id, name, null, property);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return mDTO;
	}

	public MemberDTO updateUI(String id) {

		return selectById(id);
	}

	public void update(MemberDTO mDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member set name=? where id=? and pw=?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDTO.getName());
			pstmt.setString(2, mDTO.getId());
			pstmt.setString(3, mDTO.getPw());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}

	public void delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from member where id=?";
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

	public List<MemberDTO> selectList(String property) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member where property = ? order by id";
		ResultSet rs = null;
		List<MemberDTO> list = new ArrayList<MemberDTO>();

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, property);

			pstmt.executeUpdate();

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");

				list.add(new MemberDTO(id, name, "-1", property));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	}

	public void grant(String id, String property) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member set property = ? where id = ?";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, property);
			pstmt.setString(2, id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}

	public void grantDelete(String id, String property) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql1 = "delete from (select * from member where property = 'customer' or property = 'manager') where id = ?";
		String sql2 = "delete from (select * from member where property = 'customer') where id = ?";
		try {
			conn = dataFactory.getConnection();
			if (property.equals("admin")) {
				pstmt = conn.prepareStatement(sql1);
			} else if (property.equals("manager")) {
				pstmt = conn.prepareStatement(sql2);
			}

			pstmt.setString(1, id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}

	public boolean checker(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select id from member where id = ?";
		ResultSet rs = null;
		boolean check = true;

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.executeUpdate();

			rs = pstmt.executeQuery();
			if (rs.next()) {
				check = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return check;
	}

}
