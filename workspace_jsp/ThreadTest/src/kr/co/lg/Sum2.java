package kr.co.lg;

public class Sum2 {
	public int num1;	// default 값이 0...
						// boolean 이면 default false 
						// 객체면 null
	public int num2;
	
	public int num3;
	
	Object key1 = new Object();
	Object key2 = new Object();
	Object key3 = new Object();
	
	
	public Sum2() {
	}
	
//  synchronized 붙이면 동기화문제 해결된다... 
//  동기화 메서드 
//	public synchronized void addNum1(int n) {
//		num1 = num1 + n ;
//	}
	
	
//	1. 동기화 메서드 : 키가 하나만 있다...기다리야한다... 속도가 조금 떨어짐
//	2. 동기화 블럭 : 키가 하나씩 있다...기다리지 않고 바로 실행..
	
	// 다 똑같이 this로 synchronized 해버리면 
	// 어디로 가야할지를 모르기 때문에 
	// 화장실입구문과 그안의 화장실문. 
	// 최상위인 Object 객체를 만들어서 열쇠로 사용한다.
	public  void addNum1(int n) {
		synchronized (this) {	// this 자기 자신이 열쇠...
			num1 = num1 + n;
		}
	}
	// 같은 변수,데이터를 가지고 처리하려고 할때는 
	// 열쇠를 또 만들어주면 안된다....
	public void subNum1(int n) {
		synchronized (key3) {
			num1 = num1 - n;
		}
	}
	
	
	// 새로운 열쇠를 만들어 사용할 수 있게 해준다.
	// this와는 다르기 때문에 상관없다.
	
	public void addNum2(int n) {
		synchronized (key1) {
			num2 = num2 + n;
		}
	}
	// 같은 변수,데이터를 가지고 처리하려고 할때는 
	// 열쇠를 또 만들어주면 안된다....
	public void subNum2(int n) {
		synchronized (key3) {
			num2 = num2 - n;
		}
	}
	
	public void addNum3(int n) {
		synchronized (key2) {
			num3 = num3 + n;
		}
	}
	
	
}
