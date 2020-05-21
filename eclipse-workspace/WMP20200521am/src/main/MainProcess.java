package main;

import java.util.Scanner;

import main.search.SearchProcess;

public class MainProcess {
	public MainProcess() {

		boolean isRun = true;
		int menu = -1;
		Scanner sc = new Scanner(System.in);
		while (isRun) {
			System.out.println("물류 관리");
			System.out.println("메뉴를 선택해주세요.");
			System.out.println("1: 물품 관리, 2: 창고 관리, 3: 관리자 관리, 4: 검색, 5: 종료");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				new product.com.naver.Process();
				break;
			case 2:
				new storage.com.naver.Process();
				break;
			case 3:
				new manager.com.naver.Process();
				break;
			case 4:
				new SearchProcess();
				break;
			case 5:

				isRun = false;

			}
		}
		System.out.println("프로그램 종료");
		sc.close();
	}
}
