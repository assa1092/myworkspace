package kr.co.ca;

import com.naver.UserThread1;

public class MainEx13 {
	public static void main(String[] args) {
		
		System.out.println("main start");
		Thread t = new UserThread1();
		t.setDaemon(true);	// 데몬 스레드로 만들겠다...		
		// setDaemon(true) : main 스레드가 멈추면 
		// 남은 일에 상관없이...데몬스레드도 멈추게...

		t.start();
		
		System.out.println("main end");
	}
}
