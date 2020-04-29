package com.naver;

public class Hero {
	private Weapon[] weapons;	// 가지고 있는 무기들
	private Weapon hasweapon;	// 손에 있는 무기
	
	// 디폴트 생성자
	public Hero() {
		// 세가지의 무기를 가지고 있음
		weapons = new Weapon[] {new Bow("활",1), new Sword("검",5), new Hammer("망치",10)};
		hasweapon = weapons[0];		// 기본으로 활을 가지고 있음.
	}
	
	// 사용자 정의 생성자
	public Hero(Weapon[] weapons, int idx) {
		super();
		this.weapons = weapons;
		this.hasweapon = weapons[idx];
	}
	
	// 몬스터 공격하기
	public void attack(Monster m) {
		hasweapon.attack(m);	// 가지고 있는 무기로 공격하기
	}
	
	public void changeWeapon(int idx) throws NoHaveWeaponException {
		
		if(idx >= weapons.length) {
			throw new NoHaveWeaponException();
		}
		hasweapon = weapons[idx];
		System.out.println(hasweapon);
	}
	

}
