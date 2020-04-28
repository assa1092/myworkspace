package com.naver;

import java.util.StringTokenizer;

public class StringTokenizerExample {
	public static void main(String[] args) {
		String text = "홍길동/이수홍/박연수";
		
		// how1 : 전체 토큰 수를 얻어 for문으로 루핑
		StringTokenizer st = new StringTokenizer(text, "/");
		int countToken = st.countTokens();
		for(int i=0; i<countToken;i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
		System.out.println();
		
		// how2 : 남아 있는  토큰을 확인하고 while문으로 루핑
		st = new StringTokenizer(text, "/");
		while(st.hasMoreTokens()) {
			
		}
		
		
	}

}
