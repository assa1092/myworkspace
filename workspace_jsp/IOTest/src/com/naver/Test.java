package com.naver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {
	
	public void me2() {
		

		
		File f1 = new File("C:"+ File.separator + "test.jpg");
		File f2 = new File("C:", "copytest.jpg");
		
		InputStream in = null;
		OutputStream out = null;
		
		// 배열을 이용하면 그대로 byte로...
		byte[] arr = new byte[512];
		
		try {
			in = new FileInputStream(f1);
			out = new FileOutputStream(f2);
			
			while (true) {
				int leng = in.read(arr);	// 읽어와서 배열크기만큼...집어넣는다.(채워진 배열의 인덱스를 leng 에 입력 )
				if (leng == -1) {
					break;
				}
				out.write(arr, 0, leng); // 배열의 0번째 인덱스부터 leng까지 읽어오세요...
			}
			
			System.out.println("파일 복사 완료.");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
	
	
	public void me1() {
		// byte stream 형식...
		File f1 = new File("C:"+ File.separator + "test.jpg");
		// File f1 = new File("C:","test.jpg"); // 같은 의미.
		File f2 = new File("C:", "copytest.jpg");
		
		// 스트림은 반드시 닫아줘야한다..
		// DAO에서 Connection, PreparedStatement 와 같은 구조...
		InputStream in = null;
		OutputStream out= null;
		
		int what = -1; // byte stream 을 int 에 담아서 가져간다...
		
		
		
		try {
			// 그림상 화살표까지 만들어진 경우...
			in = new FileInputStream(f1);
			out = new FileOutputStream(f2);
			
			while (true) {
				// 복사할 파일을 읽어온다...
				// 더이상 읽어올껏이 없으면 -1 이 입력된다...
				what = in.read();	// 반환형이 int형이라...앞에 선언..
				if(what == -1) {
					break;
				}
				// 다 읽어왔으면... copytest.jpg 쪽으로 넘겨준다...
				out.write(what);
			}
			System.out.println("파일 복사 종료");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	

}
