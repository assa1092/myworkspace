package com.naver;

import java.util.Scanner;

public class AAA {
	public void me1(Scanner sc) {
		System.out.println("주소를 입력하세요.");
		String msg = sc.nextLine();
		System.out.println(msg);
		// sc.close(); 
		
	}
	
	
	
	public void me1() {
		Scanner sc =  new Scanner(System.in);
		System.out.println("주소를 입력하세요.");
		String msg = sc.nextLine();
		System.out.println(msg);
	}
}
