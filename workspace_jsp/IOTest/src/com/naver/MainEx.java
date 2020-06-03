package com.naver;

public class MainEx {

	public static void main(String[] args) {
		Test2 t1 = new Test2();
		long start = System.currentTimeMillis();
		t1.me1();
		long end = System.currentTimeMillis();
		
		System.out.println(end-start);
		
		System.out.println("================================");
		
		start = System.currentTimeMillis();
		t1.me2();
		end = System.currentTimeMillis();
		System.out.println(end-start);

	}

}
