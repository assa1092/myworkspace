package kr.co.lg;

public class WriterThread extends Thread{
	Board board;
	
	public WriterThread() {
		// TODO Auto-generated constructor stub
	}

	public WriterThread(Board board) {
		super();
		this.board = board;
	}

	// Thread 니까...run() override
	public void run() {
		board.setContent("hello");
	}
	
	
}
