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
	
	//������ü..
	public void transfer(String sender, String receiver, int money) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		String sql1 = "update account set balance = balance - ? where name = ?";	// �����Ϳ��� ? ���� 
		String sql2 = "update account set balance = balance + ? where name = ?";	// �����Ϳ��� ? �����ش�.
		
		boolean isOk= false;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn.setAutoCommit(false);		// �������� ����Ŀ��, ������ ����Ŀ�� ���� ��Ŵ.
			
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, money);
			pstmt1.setString(2, sender);	// ������ ���
			
			pstmt1.executeUpdate();
			
			// ������� �°��� null�� �ƴ϶�°��̱� ������ �ݴ´�.
			pstmt1.close();
			// System.out.println(4/0);	// 4/0������ ����... Ʈ������ ��Ȳ ����
			
			// �ԱݵǴ� ���� �����
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, money);
			pstmt2.setString(2, receiver);
			
			pstmt2.executeUpdate();
			
			isOk = true;	// ������� ���� ���������� ������ٴ°�.
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {	// �������ϰ�.��Ŭ�� surround with-> try/catch (�� try/catch�Ҷ�...) 
				if(isOk) {
					conn.commit();		// true �� commit
				}else {
					conn.rollback();	// false �� rollback
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				// pstmt1 �� �ٸ� ������...
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
