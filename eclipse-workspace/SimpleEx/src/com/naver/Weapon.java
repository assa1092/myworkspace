package com.naver;



// 추상메소드 describe()를 가지고 있기때문에 
// 추상클래스로 만들어야한다.
public abstract class Weapon {
	private String name ;
	private int attackPower;
	
	public Weapon() {
		// TODO Auto-generated constructor stub
	}

	public Weapon(String name, int attackPower) {
		super();
		this.name = name;
		this.attackPower = attackPower;
	}
	
	public void attack(Monster m) {
		
		describe();
		
		int cHp = m.getHp();
		int rHp = cHp - attackPower;
		m.setHp(rHp);
		System.out.println("몬스터를 공격하였습니다");
		System.out.println(m);		//몬스터의 남은 hp 출력
	}
	
	// 추상메소드를 하나라도 가지고 있으면 추상클래스로 만들어야한다...
	
	public abstract void describe();	// describe-> 묘사하다.

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}
	
	
	
	

}
