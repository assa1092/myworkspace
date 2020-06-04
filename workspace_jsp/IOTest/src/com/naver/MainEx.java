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
		
		
		System.out.println("================================");
		Test t2 = new Test();
		start = System.currentTimeMillis();
		t2.me3();
		end = System.currentTimeMillis();
		System.out.println("me3   : "+(end-start));
		
		t2.me4();
	}

}
