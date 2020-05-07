package com.naver;

import java.util.Scanner;

public class Process {
	public Process() {
		String str = new String("hello");
		System.out.println(str);
		
		System.out.println("::::::::::::::::::::");
		
		Scanner sc = new Scanner(System.in);		// System.in 키보드로부터 입력받을 준비
		System.out.println("주소를 입력하세요.");		
		String msg = sc.nextLine();					// nextLine() 한 줄을 다 읽어옴
		System.out.println(msg);
		
		System.out.println("::::::::::::::::::::");
		System.out.println("주소를 입력하세요.");
		msg = sc.next();							// next() space를 기준으로 읽어옴(구분자가 된다.)
		
		// nextLine() 을 제외한 다른 method를 사용한 후에는
		// 반드시 nextLine() 써주어야 한다.
		sc.nextLine();								
		System.out.println(msg);
		
		System.out.println("::::::::::::::::::::");
		System.out.println("초등학교 주소를 입력하세요.");
		msg =sc.nextLine();
		System.out.println(msg);
				
		System.out.println("::::::::::::::::::::");
		System.out.println("나이를 입력하세요.");
		int age = sc.nextInt();
		sc.nextLine();
		// nextLine() 을 제외한 다른 method를 사용한 후에는
		// 반드시 nextLine() 써주어야 한다.
		
		System.out.println(age);
		
		System.out.println("::::::::::::::::::::");
		System.out.println("배송지를 입력하세요");
		msg = sc.nextLine();
		System.out.println(msg);
		
		
		// new AAA().me1();
		// Scanner 객체를 여러개 만들면 에러가 날수 있으니 
		// 1개만 만들어서 돌려서 계속 사용한다.
		
		System.out.println("################");
		new AAA().me1(sc);
		
		
		
		
		sc.close();
	}
}
