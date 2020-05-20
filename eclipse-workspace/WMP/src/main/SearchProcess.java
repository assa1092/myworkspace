package main;

import java.util.Scanner;

public class SearchProcess {
	public SearchProcess() {
		
		boolean isRun = true;
		int menu = -1;
		Scanner sc = new Scanner(System.in);
		while (isRun) {
			
			System.out.println("메뉴를 선택해주세요.");
			System.out.println("1: 제품명으로 검색, 2: 관리자명으로 검색, 3: 종료");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				break;
			case 2:
				break;
			default:
				break;
			}
		}
		System.out.println("프로그램 종료");
		
	
		
		
		
	}
}
