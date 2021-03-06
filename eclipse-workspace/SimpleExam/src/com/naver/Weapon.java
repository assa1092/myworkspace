package com.naver;


// 추상메소드 describe()때문에 추상 클래스가된다.
public abstract class Weapon {
	private String name;
	private int attackPower;
	
	
	// 디폴트 생성자
	public Weapon() {
		// TODO Auto-generated constructor stub
	}

	// 사용자 정의 생성자
	public Weapon(String name, int attackPower) {
		super();
		this.name = name;
		this.attackPower = attackPower;
	}
	
	// 몬스터 공격하기 	
	public void attack(Monster m) {
		
		describe();		// 공격 묘사 추상메소드 화살을 쏩니다.
		
		int nowHp = m.getHp();
		int remainHp = nowHp -attackPower;
		m.setHp(remainHp);
		System.out.println("몬스터를 공격합니다.");
		System.out.println(m);		
	}	
	
	
	// 추상메소드를 만들면 그 클래스는 무조건 추상 클래스가 된다...
	public abstract void describe();

	
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
