package com.naver;

public class Hero {
	private Weapon[] weapons;
	private Weapon hasweapon;
	
	public Hero() {
		weapons = new Weapon[] {new Bow("활", 1),new Sword("검", 5), new Hammer("망치", 10)};
		hasweapon = weapons[0];
	}

	public Hero(Weapon[] weapons, int idx) {
		super();
		this.weapons = weapons;
		this.hasweapon = weapons[idx];
	}
	
	public void attack(Monster m) {
		hasweapon.attack(m);
	}
	
	public void changeWeapon(int idx) throws NoHasweaponException{
		if(idx >= weapons.length) {
			throw new NoHasweaponException();
		}
		hasweapon = weapons[idx];
		System.out.println(hasweapon + " 으로 무기 변경");
	}

}
