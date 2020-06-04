package com.naver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {
	
	public void me4() {
		File f1 = new File("C:" + File.separator +"test112.txt");
		File f2 = new File("C:", "copytest112.txt");
		
		InputStream in = null;
		BufferedInputStream bis = null;
		
		OutputStream out = null;
		BufferedOutputStream bos = null;
		
		
		
		try {
			in = new FileInputStream(f1);
			bis = new BufferedInputStream(in);
			
			out = new FileOutputStream(f2);
			bos = new BufferedOutputStream(out);
					
			int what = -1;
			
			while (true) {
				what = bis.read();
				if (what == -1) {
					break;
				}
				bos.write(what);
			}
			
			System.out.println("파일 복사 완료.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
				if (out != null) {
					out.close();
				}
				if (bis != null) {
					bis.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public void me3() {
		File f1 = new File("C:"+ File.separator + "show.jpg");
		File f2 = new File("C:", "copyshow.jpg");
		
		// 스트림은 무거워서 무조건 닫아주어야한다.
		InputStream in = null;
		BufferedInputStream bis = null;
		
		OutputStream out = null;
		BufferedOutputStream bos = null;
		
		try {
			// 추상클래스라 객체를 만들 수 없다..
			
			in = new FileInputStream(f1);		// 그림에서 노드스트림 화살표까지 만들어진것.
			bis = new BufferedInputStream(in);
						
			out = new FileOutputStream(f2);
			bos = new BufferedOutputStream(out);
			// 자료 지나갈 통로 까지 완성...
			
			int what = -1;
			
			while (true) {
				what = bis.read();
				if (what == -1) {
					break;
				}
				bos.write(what);
			}
			System.out.println("파일 복사 종료.");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { 
				// 우선순위...
				// 장치에 바로 연결되는 노드 스트림 먼저 지우면 안된다..
				// 필터 스트림 먼저 지워야 한다.
				// 그래서 버퍼스트림 먼저 삭제...
				if (bos != null) {
					bos.close();
				}
				if (out != null) {
					out.close();
				}
				if (bis != null) {
					bis.close();
				}
				if (in != null) {
					in.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
		
	}
	
	
	public void me2() {
		

		
		File f1 = new File("C:"+ File.separator + "test.jpg");
		File f2 = new File("C:", "copytest.jpg");
		
		InputStream in = null;
		OutputStream out = null;
		
		// 배열을 이용하면 그대로 byte로...
		// 버퍼의 개념과 비슷
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
