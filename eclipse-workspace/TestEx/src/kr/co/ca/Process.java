package kr.co.ca;

import java.util.Scanner;

import com.naver.Bow;
import com.naver.Hammer;
import com.naver.Hero;
import com.naver.Monster;
import com.naver.NoHasweaponException;
import com.naver.Sword;
import com.naver.Weapon;

public class Process {
	
	public Process() {
		
		Monster m = new Monster(100);
		
		Weapon[] weapons = {new Bow("활", 10),new Sword("검", 20), new Hammer("망치", 30)};
		int hasWeaponIdx = 0;
		
		Hero spiderman = new Hero(weapons, hasWeaponIdx);
		
		
		Scanner scanner = new Scanner(System.in);
		
		
		boolean run = true;
		
		while(run) {
			System.out.println("========================");
			System.out.println(m);
			System.out.println(" 1.공격 2.무기변경 3.종료 ");
			
			int selectNo =  scanner.nextInt();
			scanner.nextLine();
			
			switch (selectNo) {
			case 1:
				spiderman.attack(m);
				break;
			case 2:
				try {
					System.out.println("========================");
					System.out.println(" 1.활 2.검 3.망치 ");
					hasWeaponIdx = scanner.nextInt();
					scanner.nextLine();
					spiderman.changeWeapon(hasWeaponIdx-1);
				} catch (NoHasweaponException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("무기변경 실패");
				}
				break;
			case 3:
				run = false;
				break;
			
			}
		}
		
		
		
		
		
	}
	
}
