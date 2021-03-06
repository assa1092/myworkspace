package com.naver;

import java.util.StringTokenizer;

public class Test {
//	변수 선언 공식
//	자료형 변수명 =  자료형에 맞는 값;
//	boolean: true, false
//	char: '' char c=64; char a=97;
//	byte: -128 ~127
//	short
//	int :21억
//	long long a = 333L;
//	float f = 3.132F;
//	double d= 3.13;
// new -> heep memory 에 새로운 객체를 만들고 저장
//	자료형 변수명(reference) = new 생성자();
//	String msg = "hello";			//암시적 객체 생성법
//	String msg1 = new String("hello");	// 명시적 객체 생성법
	
	public void me183() {
		String data = "id#age##birth";
		
		
		// .split()는 ## 토큰구분자 사이도 하나의 토큰으로 인식
		String[] arr1 = data.split("#");
		System.out.println(arr1.length);	//  길이 : 4

		// StringTokenizer() 는 ## 토큰구분자 사이는 토큰으로 인식하지 않음
		StringTokenizer st =  new StringTokenizer(data, "#");		
		System.out.println(st.countTokens());		//	길이 : 3
	}
	
	
	
	public void me182() {
		String data = "teacheryo#46#1#4000";
		StringTokenizer st = new StringTokenizer(data, "#");
		String[] arr = new String[st.countTokens()];
		int idx=0;
				
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			arr[idx]= token;		//	arr[idx++] = token;
			idx++;
		}
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		
	
	}
	
	
	public void me18() {
		String data = "teacheryo#46#1#4000";
		
		// split()의 리턴타입이 String[]
		String[] arr = data.split("#");
		String id = arr[0];
		String age = arr[1];
		String grade= arr[2];
		String point =arr[3];
		System.out.println(id+ "님의 남은 포인트는 "+ point +"입니다." );
	}
	
	
	public void me17(int start, int end) {
		for(int i =start; i< end+1;i++) {
			me16(i);
		}
	}
	
	
	
	// 소수 1과 자기자신 외에는 약수가 없는수
	// 소소찾기 2, 3, 5, 7, 11,...
	public void me16(int num) {
		boolean isSosu =true;
		
		for(int i=2;i<num;i++) {
			if(num%i ==0) {
				isSosu = false;
				break;
			}
			
		}
		if(isSosu) {
			System.out.println(num+" 는 소수입니다.");
		}else {
			System.out.println(num + "는 소수가 아닙니다.");
		}
		
	}
	
	
	
	//0,0,0,0,1,1,1,1,2,2,2,2,3,3,3,3....
	public void me15() {
		for(int i=0; i<100;i++) {
			int gab = i/4;
			System.out.print(gab+ ",");
		}
		
	}
	
	
	
	// 3 ~ 5 : 3, 4, 5
	// 3 ~ 5 : 3, 4		대부분 생각하는 것보다 1개 더 적다....
	public void me143() {
		String msg = "hello world good morning";
		String newMsg = msg.substring(6, 16);
		System.out.println(newMsg);
	}
		
	// me142()메서드는 
	// 파일명을 외부에서 입력받아(_)
	// 원래 파일명을 반환하는 기능을 갖고있음.
	
	public String me142(String filename) {
		int idx =filename.indexOf("_");
		String org = filename.substring(idx+1);
		
		return org;
		
	}
		
	public void me14() {
		
		String msg = "xxxxxxxxxx_hello.jpg";
		int idx =msg.indexOf("_");
		// 3 ~ 5 : 3, 4, 5
		// 3 ~ 5 : 3, 4		대부분 생각하는 것보다 1개 더 적다....
		// 그래서 생각하는 것보다 1을 더해야 원하는것이 대부분 나온다.
		String newMsg = msg.substring(idx+1);
		System.out.println(newMsg);

	}
	
	public void me13() {
		String msg = "     hello      world     ";
		String newMsg = msg.trim();			// 문자열 앞뒤 공백 잘라내기
		System.out.println(msg);			//     hello      world     
		System.out.println(newMsg);			// hello      world
	}
	
	
	
	public void me12() {
		String msg = "hello";
		int leng = msg.length();		// 문자열 길이
		System.out.println(leng);
		System.out.print("leng-1 : ");
		System.out.println(leng-1);		// 문자열 최대크기
	}
	
	
	
	
	public void me112() {
		String msg = "hello.jpg";
		String newMsg="xxxxxxxxxx_" + msg;
		int idx = newMsg.indexOf("_");
		System.out.println(idx);		// 10
	}
	
	
	
	public void me11() {
		String msg = "x8jeosz2_emypicture.jpg";
		int idx = msg.indexOf("_");
		System.out.println(idx);		// 8
		idx = msg.indexOf("e");			// 먼저 나오는 문자를 인식
		System.out.println(idx);		// 3
		
		idx = msg.lastIndexOf("e");		// 찾은것중에 마지막 인덱스 
		System.out.println(idx);		// 18
		
		idx = msg.indexOf("e", 5);		// e 를 찾는데 5번째 문자열부터 검색
		System.out.println(idx);		// 9
		
	}
	
	
	public void me10() {
		String msg = "a.jpg";
		boolean is = msg.endsWith(".jpg");	// .jpg 로 끝났는지 여부
		System.out.println(is);				// true
	
	}
	
	
	
	public void me9() {
		String msg = "hello";
		boolean is=	msg.contains("zz");		// 어떤것 을 검색할때...
		System.out.println(is);				// false
	}
	
	
	
	
	// me81() 메서드는 
	// 문자열과 그 문자열의 특정 인덱스를 넘겨받아서
	// 그 인덱스에 해당하는 문자를 출력하는 기능을 갖고 있다.
	
	public void me81(String str, int idx) {
		char c = str.charAt(idx);
		System.out.println(c);
		
		
	}	
	
	public char me8() {
		String msg = "hello";
		char c = msg.charAt(0);
		return c;
		
	}
	
	
	//0, 1, 2, 3,0, 1, 2, 3, ... 출력하기 
//	public void me7() {
//
//		for(int i=0;i<100;i++) {
//			int dap = i%4;
//			System.out.println(dap);
//		}
//	}
	public void me00() {
		for(int i=2; i<10;i++) {
//			for(int j=1;j<10;j++) {
//			StringBuffer sb	=new StringBuffer();
//			sb.append(i);
//			sb.append("X");
//			sb.append(j);
//			sb.append("=");
//			sb.append(i*j);
//			
//			System.out.println(sb.toString());
//			
//			
//			}
			me62(i);
			System.out.println("--------------------------");
		}
	}
	
	
	public void me62(int dan) {
		
		for(int i=1;i<10; i++) {
			// String의 불변성 때문에 메모리 많이 차지
			// StringBuffer은 String의 불변성 대체로 사용...
			
			StringBuffer sb =  new StringBuffer();
			sb.append(dan);
			sb.append("X");
			sb.append(i);
			sb.append("=");
			sb.append(dan*i);
			
			 System.out.println(sb.toString());
			 
			//System.out.println(dan + "X" + i + "=" + i*dan);
		}
	}
	
	
	
	
	public void me61() {
		StringBuffer sb = new StringBuffer();
		sb.append("hello");
		sb.append(" world");
		sb.append(" !!!");
		
		String msg = sb.toString();
		System.out.println(msg);
	}
	
	
	public void me6() {
		String msg = "hello";
		msg += "world";  
		msg += "!!!";
		System.out.println(msg);
	}
	
	public void me5() {
		String msg1 = new String ("hello");
		String msg2 = new String ("hello");
		String msg3 =  new String("Hello");
		
		
		// 반환형이 있는 메소드는 받는 값이 있어야한다.
		boolean b = msg1.equals(msg2);
		System.out.println(b);
		
		System.out.println(msg2.equals(msg3));
	}
	
	
	public void me4() {
		String msg1 = new String("hello");
		String msg2 = new String("hello");
		String msg3 = msg2;
		
		System.out.println(msg1 == msg2);
		System.out.println(msg2 == msg3);
		
	}
	
	
	public void me3() {
		String msg1 = "hello";
		String msg2 = "Hello";
		System.out.println(msg1== msg2);
		
		
	}
	
	public boolean me2() {
		String msg1 = "hello";
		String msg11 = "hello";
		
		return msg1 == msg11;
	}
	
	
	
	
	public void me1() {
		String msg1 = "hello";
		String msg2 = new String("hello");
		
		
		System.out.println(msg1==msg2);
	}

}
