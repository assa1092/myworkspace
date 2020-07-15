package kr.co.ca;

import com.naver.UserRunnable1;

// 1. UserRunnable 클래스 생성. 단, Runnable 인터페이스 구현.
// 2. run()메서드에 사용자 스레드에서 실행할 코드를 작성
// 3. UserRunnable 클래스를 이용해서 runnable 객체를 만듦.
// 4. Thread 클래스를 이용해서 스레드 객체를 만듦.(runnable객체를 파라미터 넣는다).
// 5. 스레드 객체가 갖고 있는 start() 메서드 호출
public class MainEx3 {

	public static void main(String[] args) {
		System.out.println("main start");
		UserRunnable1 ur1 = new UserRunnable1();
		Thread urt1 = new Thread(ur1);
		urt1.start();
		System.out.println("main end");
	}

}
