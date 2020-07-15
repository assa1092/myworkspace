package kr.co.ca;

import com.naver.UserThread1;


// 사용자 스레드 생성 순서
// 1. 스레드 클래스를 상속하는 자식 클래스를 만듦
// 2. 사용자의 스레드에서 실행할 코드를 자식클래스의 run()메서드에 작성
// 3. 자식 클래스를 이용해서 스레드 객체를 만듦
// 4. 스레드 객체가 갖고있는 start()메서드를 호출함.
public class MainEx2 {
	public static void main(String[] args) {
		System.out.println("main start");		// 가장먼저 실행
		UserThread1 ut1 = new UserThread1();	// 객체 만들어서 사용할 준비.
		ut1.start();							// 2번째로 시작하라고 함.
		System.out.println("main end");			// 3번째로 시작. 2번째가 끝날때까지 기다리는게 아니다.
	}
}
