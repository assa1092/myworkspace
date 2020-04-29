package kr.co.kr;

import com.naver.Bow;
import com.naver.Hammer;
import com.naver.Hero;
import com.naver.Monster;
import com.naver.Sword;
import com.naver.Weapon;

public class MainEx {
	public static void main(String[] args) {
		
		Monster m = new Monster(10);
		
		System.out.println(m);
		
		Weapon[] weapons = {new Bow("활",1), new Sword("검",5), new Hammer("망치",10)};
		int hasweaponIdx = 0;
		
		Hero spiderman = new Hero(weapons, hasweaponIdx);
		
		spiderman.attack(m);
		
		spiderman.changeWeapon(1);
		
		spiderman.attack(m);
		
		spiderman.changeWeapon(10);
				
		
	}

}
