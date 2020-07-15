package kr.co.lg;

public class YourThread2 extends Thread{

	public int start;
	public int end;
	public Sum2 sum;
	
	public YourThread2() {
		// TODO Auto-generated constructor stub
	}

	public YourThread2(int start, int end, Sum2 sum) {
		super();
		this.start = start;
		this.end = end;
		this.sum = sum;
	}
	
	public void run() {
		
		for (int i = start; i <= end; i++) {
			sum.addNum1(i);
			sum.addNum2(i);
			sum.addNum3(i);
			
		}
		
	}
	
	
}
