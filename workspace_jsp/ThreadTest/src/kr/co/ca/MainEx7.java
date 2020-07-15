package kr.co.ca;

import com.naver.UserRunnable1;
import com.naver.UserThread1;

public class MainEx7 {

	public static void main(String[] args) {

		System.out.println("main start");

		// 숫자
		UserThread1 my = new UserThread1();
		my.start();
		
		// 문자
		UserRunnable1 ur1 = new UserRunnable1(my);
		Thread you = new Thread(ur1);
		you.start();
		
		// my 스레드가 항상 you스레드보다 작업이 일찍 끝나게 하려면...
		// UserRunnable1 클래스의 run()메서드에서 join()메서드 호출
		System.out.println("main end");

	}

}
