package com.naver;

public class Pibonachi {
	public Pibonachi() {
		long[] arr=new long[100];
		arr[0]=1;
		arr[1]=1;
		
		for(int i=2;i<arr.length;i++) {
			arr[i] = arr[i-1] + arr[i-2];		
		}
		for(int i=0; i<arr.length;i++) {
			System.out.println(arr[i]);
		}

	}
	
	
}
