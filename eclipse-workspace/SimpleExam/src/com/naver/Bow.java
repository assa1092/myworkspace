package com.naver;


// 추상클래스를 상속받았기때문에 
// 추상메소드인 describe() 재정의 해야한다. 
public class Bow extends Weapon {
	// 디폴트 생성자
	public Bow() {
		// TODO Auto-generated constructor stub
	}
	// 사용자 정의 생성자..overloading
	public Bow(String name, int attackPower) {
		super(name, attackPower);
		// TODO Auto-generated constructor stub
	}

	// 추상메소드 재정의
	@Override
	public void describe() {
		System.out.println("화살을 마구 쏩니다.");
		
	}
	
	
}
