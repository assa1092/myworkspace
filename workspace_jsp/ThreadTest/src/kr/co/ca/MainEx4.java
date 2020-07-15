package kr.co.ca;

import com.naver.UserRunnable1;
import com.naver.UserThread1;

public class MainEx4 {

	public static void main(String[] args) {
		System.out.println("main start");
		
		// 숫자
		UserThread1 ut1 = new UserThread1();
		ut1.start();
		
		// 문자
		UserRunnable1 ur1 = new UserRunnable1();
		Thread urt1 = new Thread(ur1);
		urt1.start();
				
		System.out.println("main end");

	}

}
