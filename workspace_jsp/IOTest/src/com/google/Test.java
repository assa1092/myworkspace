package com.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;


public class Test {
	
	public void me4() {
		File f1 = new File("C:"+ File.separator + "no.txt");
		
		InputStream in = null;			// 바이트 스트림
		InputStreamReader isr = null;	// 바이트 스트림 과 문자 스트림의 연결자...
		BufferedReader br = null;		// 문자 스트림
		
		try {
			in = new FileInputStream(f1);
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			
			while (true) {
				String msg = br.readLine();
				if ( msg == null) {
					break;
				}
				System.out.println(msg);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (in != null) {
					in.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		f1.renameTo(new File("C:","nono.txt"));
				
		
	}
	
	public void me3() {
		// 문자 스트링 사용할때 주의할 사항...()
		
		Writer out = null;
		BufferedWriter bw = null;
		
		Reader in = null;
		BufferedReader br = null;
		
		try {
			
			// 먼저 출력하고 나서 나중에 다시 입력할 경우...
			// 바이트 스트림에서는 읽어진다...
			
			// 그러나 문자 스트림에서는 안 읽어진다...(~er로 끝나는 것들...)
			// 그래서...bw.flush(); 을 마지막에 호출해야한다...
			
			// 출력할때 없으면 파일을 자동으로 만들어준다...
			out = new FileWriter("C:" + File.separator + "no.txt");
			bw = new BufferedWriter(out);
			
			bw.write("hello");
			bw.write(System.getProperty("line.separator"));		
			// bw.newLine();		// 줄 바꿈...
			bw.write("world");
			// bw.newLine();
			bw.write(System.getProperty("line.separator"));
			bw.write("good");
			// bw.newLine();
			bw.write(System.getProperty("line.separator"));
			bw.flush();
			
			
			in = new FileReader("C:" + File.separator + "no.txt");
			br = new BufferedReader(in);
			
			while (true) {
				String msg = br.readLine();	// br을 이용해서 한줄씩 읽어온다..
				if (msg == null) {
					break;
				}
				System.out.println(msg);		
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (out != null) {
					out.close();
				}
				if (br != null) {
					br.close();
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
		// 대부분 잘 쓰는 코드...
		File f1 = new File("C:", "test112.txt");
		File f2 = new File("C:", "copytest113.txt");
		
		// BufferedReader...이용..
		// 한글자씩이 아니라 한줄씩..줄바꿈 나올때까지...
		Reader in = null;
		BufferedReader br = null;	// 일반적으로는 Spliterator과 같이 씀...
				
		Writer out = null;
		BufferedWriter bw = null;
		
		try {
			// 
			in = new FileReader(f1);
			br = new BufferedReader(in);
			
			out = new FileWriter(f2);
			bw = new BufferedWriter(out);
			
			// 한줄씩 읽어오므로 문자열로 받는다..
			String msg = "";
			while (true) {
				msg = br.readLine();
				if(msg == null) { 
					break;
				}
				
				bw.write(msg);
				// 계속 읽어오다가 줄바꿈이 있으면 무시하고 가져와서 그대로 붙인다...
				// 그래서 줄바꿈 없이 그냥 한줄로...나온다...
				// 그래서 줄바꿈을  넣어준다...
				// bw.newLine(); 이렇게 넣어주기도 한다.
				bw.write(System.getProperty("line.separator"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (in != null) {
					in.close();
				}
				if (bw != null) {
					bw.close();
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
		
		// 잘 안쓰는 코드...
		
		File f1 = new File("C:" + File.separator + "test112.txt");
		File f2 = new File("C:" + File.separator + "coppytest112.txt");
		
		Reader in = null;
		Writer out = null;
		
		try {
			in = new FileReader(f1);
			out = new FileWriter(f2);
			
			// 1바이트씩 읽어오니 char 배열 로 ..
			char[] arr = new char [64];
			int leng = -1;
			
			while (true) {
				
				leng = in.read(arr, 0, arr.length);
				 // leng = in.read(arr); 같은 의미...
				if (leng == -1) {
					break;
				}
				out.write(arr, 0, leng);
			}
			
			
			
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
