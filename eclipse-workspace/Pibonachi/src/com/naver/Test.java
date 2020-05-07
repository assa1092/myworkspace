package com.naver;

public class Test {
	
	public void me2() {		// 배열을 이용한 피보나치
		long[] arr = new long[100];
		arr[0] = 1;
		arr[1] = 1;
	/*  
	 *  System.out.println(arr[0]);
		System.out.println(arr[1]);
		for(int i = 2;i<arr.length;i++) {
			arr[i] = arr[i-1] + arr[i-2];
			System.out.println(arr[i]);
		} 
	*/
		for(int i=2;i<arr.length;i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		for(long x :arr) {		// arr 배열의 값을 하나씩 x 로 받는다...
			System.out.println(x);
		}
		
		
	}
	
	
	public void me1() {	// 배열없이 for문 피보나치
		int p2=1; 		 // 전에 전 것
		int p1 = 1;		// 전에 것
		System.out.println(p2);
		System.out.println(p1);
		int cur=-1;		//현재 값.
		
		for(int i=0; i<98; i++) {
			cur = p2+p1;
			System.out.println(cur);
			
			p2 = p1;	// 전에전 값이 전 값으로
			p1 = cur;	// 현재값이 전 값으로
		}
	}
}
