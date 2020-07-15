package kr.co.ca;

import com.naver.UserRunnable1;
import com.naver.UserThread1;

public class MainEx6 {

	public static void main(String[] args) {
		System.out.println("main start");

		// 숫자
		UserThread1 ut1 = new UserThread1();
		ut1.start();
		
		// 문자
		UserRunnable1 ur1 = new UserRunnable1();
		Thread urt = new Thread(ur1);
 
		urt.start();
		
		// urt 스레드가 항상 ut1스레드보다 작업이 일찍 끝나게 하려면...
		// UserRunnable1 클래스의 run()메서드에서 join()메서드 호출
				
		try {
			urt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main end");

	}

}
