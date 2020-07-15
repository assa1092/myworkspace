package kr.co.ca;

import kr.co.lg.Sum2;
import kr.co.lg.YourThread2;

public class MainEx11 {

	public static void main(String[] args) {
		Sum2 sum = new Sum2();
		
		YourThread2 y1 = new YourThread2(0, 5000, sum);
		YourThread2 y2 = new YourThread2(5001, 10000, sum);
		
		
		y1.start();
		y2.start();
		
		try {
			y1.join();	// main 끝나기 전에 y1을 먼저끝낸다.
			y2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sum.num1);
	}

}
