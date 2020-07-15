package kr.co.ca;

public class MainEx {

	public static void main(String[] args) {
		Thread ct = Thread.currentThread();		// .currentThread()현제 스레드
		String ctname = ct.getName();
		System.out.println(ctname);		// main

	}

}
