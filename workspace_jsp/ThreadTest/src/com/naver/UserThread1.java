package com.naver;


//사용자 스레드 생성 순서
//1. 스레드 클래스를 상속하는 자식 클래스를 만듦
//2. 사용자의 스레드에서 실행할 코드를 자식클래스의 run()메서드에 작성
//3. 자식 클래스를 이용해서 스레드 객체를 만듦
//4. 스레드 객체가 갖고있는 start()메서드를 호출함.
public class UserThread1 extends Thread{

	public void run() {
		for(int i=0;i<10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);		// 밀리세컨드(1/1000) 단위 동안 대기후 실행.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
