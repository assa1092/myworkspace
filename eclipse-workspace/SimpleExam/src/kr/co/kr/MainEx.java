package kr.co.kr;

import com.naver.Bow;
import com.naver.Hammer;
import com.naver.Hero;
import com.naver.Monster;
import com.naver.NoHaveWeaponException;
import com.naver.Sword;
import com.naver.Weapon;

public class MainEx {
	public static void main(String[] args) {
		
		Monster m = new Monster(10);		// hp10가진 몬스터 생성
		
		System.out.println(m);				// toString() 재정의로 몬스터의 hp 보여줌.
		
		// 무기 세가지를 주어짐
		Weapon[] weapons = {new Bow("활",1), new Sword("검",5), new Hammer("망치",10)};
		int hasweaponIdx = 0;		// 그 중 활을 장착. 
		
		Hero spiderman = new Hero(weapons, hasweaponIdx);	// 세가지 무기중 활을 장착한 스파이더맨 생성
		
		spiderman.attack(m);	// 활로 공격
		
		try {
			spiderman.changeWeapon(1);		// 무기 검으로 변경
		} catch (NoHaveWeaponException e) {
			// TODO Auto-generated catch block
			System.out.println("무기변경에 실패하였습니다.");
		}
		
		spiderman.attack(m);		// 변경된 검으로 공격
		
		try {
			spiderman.changeWeapon(0);		// 다시 활로 변경
		} catch (NoHaveWeaponException e1) {
			// TODO Auto-generated catch block
			System.out.println("무기변경에 실패하였습니다.");			
		}
		
		spiderman.attack(m);		// 변경된 활로 공격
		
		
		try {
			spiderman.changeWeapon(10);			// 무기중 11번째 무기로 변경
		} catch (NoHaveWeaponException e) {
			// TODO Auto-generated catch block		// 11번째 무기가 없어서 예외처리
			System.out.println("무기변경에 실패하였습니다.");
		}
				
		
	}

}
