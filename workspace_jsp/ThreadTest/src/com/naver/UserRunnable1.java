package com.naver;



//1. UserRunnable 클래스 생성. 단, Runnable 인터페이스 구현.
//2. run()메서드에 사용자 스레드에서 실행할 코드를 작성
//3. UserRunnable 클래스를 이용해서 runnable 객체를 만듦.
//4. Thread 클래스를 이용해서 스레드 객체를 만듦.(runnable객체를 파라미터 넣는다).
//5. 스레드 객체가 갖고 있는 start() 메서드 호출


public class UserRunnable1 implements Runnable{

	// 스레드 객체생성...default는 null
	private Thread my;
	
	public UserRunnable1() {
	
	}
	
	// 파라미터로 받은 my를 사용한다..
	public UserRunnable1(Thread my) {	
		this.my = my;
	}



	public void run() {
		try {
			my.join();
		// my 스레드가 끝날 때까지 아래 코드가 실행되지 않는다.
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		for(int i=0;i<10;i++) {
			char c = (char) (65+i);
			System.out.println(c);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
