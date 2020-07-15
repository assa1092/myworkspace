package kr.co.lg;

public class Sum {
	public int num1;	// default 값이 0...
						// boolean 이면 default false 
						// 객체면 null
	
	public Sum() {
		// TODO Auto-generated constructor stub
	}
	
	// synchronized 붙이면 동기화문제 해결된다...
	public synchronized void addNum1(int n) {
		num1 = num1 + n ;
	}
}
