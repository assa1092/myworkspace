package com.naver;

public class Hero {
	
	private Weapon[] weapons;
	private Weapon hasWeapon; 		// 손에 들고있는 무기
	
	public Hero() {
		weapons = new Weapon[] {new Bow("활",1), new Sword("검",5), new Hammer("망치",10)};
		
//		hasWeapon = new Bow("활",1);   // 이건 새로운 활을 만든것 무기 4개가 됨....new 연산자
		hasWeapon = weapons[0];		  // 가지고있는 세가지 중에서 첫번째인 활을 착용한것...
	}

	public Hero(Weapon[] weapons, int idx) {
		super();
		this.weapons = weapons;
		this.hasWeapon = weapons[idx];
	}
	
	// 공격(공격 받을 대상)
	public void attack(Monster m) {
		hasWeapon.attack(m);
	}
	
	// 무기교체
	public void changeWeapon(int idx) throws NoHaveWeaponException {
		// 
		if(idx >= weapons.length) {
			//idx = weapons.length-1;
			throw new NoHaveWeaponException();
		}
		
		hasWeapon = weapons[idx];
		System.out.println(hasWeapon);	// 지금 가지고있는 무기 출력
	}
	
	

}
