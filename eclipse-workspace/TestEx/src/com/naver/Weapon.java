package com.naver;

public abstract class Weapon {
	private String name;
	private int attackPower;
	
	public Weapon() {
		// TODO Auto-generated constructor stub
	}

	public Weapon(String name, int attackPower) {
		super();
		this.name = name;
		this.attackPower = attackPower;
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
	
	@Override
	public String toString() {
		return name;
	}

	public void attack(Monster m) {
		describe();
		
		int nowHp = m.getHp();
		int remainHp = nowHp - attackPower;
		m.setHp(remainHp);
		System.out.println("몬스터를 공격합니다.");
		System.out.println(m);
	}

	public abstract void describe();

}
