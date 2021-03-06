package com.naver;

public class Monster {
	private int hp;
	
	
	// 사용자 정의 생성자
	public Monster(int hp) {
		super();
		this.hp = hp;
	}
	
	// 디폴트 생성자
	public Monster() {
		// TODO Auto-generated constructor stub
	}

	// private 변수에 접근하기위한 getter()
	public int getHp() {
		return hp;
	}

	// private 변수에 접근하기위한 setter()
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	// 몬스터 객체 부를때 toString() 재정의
	@Override
	public String toString() {
		return "Monster [hp=" + hp + "]";
	}
	
	

}
