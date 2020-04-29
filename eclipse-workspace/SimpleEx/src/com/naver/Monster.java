package com.naver;

public class Monster {
	private int hp;
	
	public Monster() {
		// TODO Auto-generated constructor stub
	}
	

	public Monster(int hp) {
		super();
		this.hp = hp;
	}


	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}


	@Override
	// 몬스터 객체를 호출할때 
	// 16진수가 아닌 내가 원하는 걸로 보이기위해 재정의
	public String toString() {
//		return "monster [hp=" + hp + "]";
		return "monster hp: "+ hp;
	}
	
	
	
	

}
