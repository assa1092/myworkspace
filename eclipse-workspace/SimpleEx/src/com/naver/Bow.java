package com.naver;


// Weapon이 추상클래스이므로 describe() 재정의 해야한다.
public class Bow extends Weapon {
	
	public Bow() {
		super("활", 1);	// 사용자 생성자가있기때문에 사용가능.
	}
	
	
	public Bow(String name, int attackPower) {
		super(name, attackPower);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void describe() {
		System.out.println("화살을 마구 쏩니다.");
	}




	@Override
	public String toString() {
		// 부모클래스가 가지고있는 name가져옴
		// 샹속받았기때문에 getName해도 가능.
		return super.getName();
	}
	
	

}
