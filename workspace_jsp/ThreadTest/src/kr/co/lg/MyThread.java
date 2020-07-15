package kr.co.lg;

public class MyThread extends Thread {
	
	public SyncTest st; 
	
	public MyThread() {
		// TODO Auto-generated constructor stub
	}

	public MyThread(SyncTest st) {
		this.st = st;
	}

	// Thread 상속받았으니 run() override
	public void run() {
		st.addNum();
	}
	
	
	
}
