package kr.co.lg;

public class YourThread extends Thread{

	public int start;
	public int end;
	public Sum sum;
	
	public YourThread() {
		// TODO Auto-generated constructor stub
	}

	public YourThread(int start, int end, Sum sum) {
		super();
		this.start = start;
		this.end = end;
		this.sum = sum;
	}
	
	public void run() {
		
		for (int i = start; i <= end; i++) {
			sum.addNum1(i);
		}
		
	}
	
	
}
