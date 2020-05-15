package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "ca2";	
	private final String PASSWORD = "ca2";
	
	public AccountDAO() {
		try {
			Class.forName(DRIVERNAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//계좌이체..
	public void transfer(String sender, String receiver, int money) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		String sql1 = "update account set balance = balance - ? where name = ?";	// 기존것에서 ? 빼서 
		String sql2 = "update account set balance = balance + ? where name = ?";	// 기존것에서 ? 더해준다.
		
		boolean isOk= false;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn.setAutoCommit(false);		// 기존에는 오토커밋, 지금은 오토커밋 해제 시킴.
			
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, money);
			pstmt1.setString(2, sender);	// 보내는 사람
			
			pstmt1.executeUpdate();
			
			// 여기까지 온것은 null이 아니라는것이기 때문에 닫는다.
			pstmt1.close();
			// System.out.println(4/0);	// 4/0나누면 에러... 트렌젝션 상황 만듬
			
			// 입금되는 형태 만들기
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, money);
			pstmt2.setString(2, receiver);
			
			pstmt2.executeUpdate();
			
			isOk = true;	// 여기까지 오면 정상적으로 실행됬다는것.
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {	// 블럭설정하고.우클릭 surround with-> try/catch (블럭 try/catch할때...) 
				if(isOk) {
					conn.commit();		// true 면 commit
				}else {
					conn.rollback();	// false 면 rollback
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				// pstmt1 은 다른 곳에서...
				if(pstmt2 != null) {
					pstmt2.close();
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
