package kr.co.lg;

public class Board {
	private String content;

	boolean isOk = false;	// 작가가 글을 올렸는지 여부
	
	public String getContent() {	// 작가가 아직 글을 안올린경우 
		if (!isOk) {	// isOk == false
			
		// try-catch로 묶고, wait를 동기화블럭으로 묶어야 한다.
			try {		
				synchronized (this) {	// 올리기전까지 무조건 기다려...대기
					wait(); 
					// wait(); Object 안에 메소드
					// wait(); 호출하면 반드시 동기화메소드, 동기화블럭이든 무조건 하나는 해야한다.
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		isOk = true;
		
		synchronized (this) {
			notifyAll();	// wait() 풀어주는거...
		}
		
	}
	
}
