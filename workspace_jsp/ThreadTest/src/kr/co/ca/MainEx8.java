package kr.co.ca;

public class MainEx8 {

	public static void main(String[] args) {
		// 내부클래스... 익명 객체로 사용하기도...
		new Thread(new Runnable() {
			
			// 딱 한번만 사용할때....
			// 그런경우에만 익명객체로 사용....
			// 주로 통신할때...
			
			public void run() {
				for(int i=0; i<10;i++) {
					System.out.println(i);
				}
				
			}
		}).start();		// 익명 객체로 사용하는것은 일회용...	

	}

}
