package kr.co.ca;

import java.util.Scanner;

import com.naver.Bow;
import com.naver.Hammer;
import com.naver.Hero;
import com.naver.Monster;
import com.naver.NoHasweaponException;
import com.naver.Sword;
import com.naver.Weapon;

public class ProcessEx {
	
	Monster m = new Monster(100);
	Weapon[] weapons = {new Bow("활", 1),new Sword("검", 5), new Hammer("망치", 10)};
	int hasidx = 0;
	
	Hero spiderman = new Hero(weapons, hasidx);
	
	public ProcessEx() {
		Scanner sc = new Scanner(System.in);	 // sc.close(); 와 한 세트...
		boolean isTrue = true;
		
		while(isTrue) {
			System.out.println("menu를 선택하시오.");
			System.out.println("1:공격, 2:무기변경, 3:종료");
			int menu =sc.nextInt();
			sc.nextLine();	//nextLine()를 제외한 다른 메소드에는 무조건 다음에 붙여준다.
			
			switch (menu) {
			case 1:
				spiderman.attack(m);
				break;
			case 2:
				System.out.println("무기를 선택하시오.");
				int idx = 0;
				for (Weapon w : weapons) {
					System.out.print(idx++);
					System.out.print(":");
					System.out.print(w);
					
					if(idx < weapons.length-1) {	//	무기들중 젤 마직막 앞에서는 , 찍지 않는다...
						System.out.print(",");
					}
				}	
					System.out.println();
					
					 int widx = sc.nextInt();
					 sc.nextLine();	//nextLine()를 제외한 다른 메소드에는 무조건 다음에 붙여준다.
					 
					 try {
						spiderman.changeWeapon(widx);
					} catch (NoHasweaponException e) {
						// TODO Auto-generated catch block
						System.out.println("무기변경 실패");
					}
					 break;
					 
				default:
				isTrue = false;
				break;
			}
		}
		
		
		sc.close();
	}

}
