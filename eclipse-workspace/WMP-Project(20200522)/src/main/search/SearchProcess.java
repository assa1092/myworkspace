package main.search;

import java.util.Scanner;

import main.MainCommand;

public class SearchProcess {
	public SearchProcess() {
		MainCommand[] command = { new SearchByIdCommand(), new SearchByPNameCommand(), new SearchByMNameCommnad(),
				new SearchByStypeCommand() };
		boolean isRun = true;
		int menu = -1;
		Scanner sc = new Scanner(System.in);

		while (isRun) {

			System.out.println("메뉴를 선택해주세요.");
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------");
			System.out.println("0: 관리자 아이디로 검색 | 1: 제품명으로 검색 | 2: 관리자 이름으로 검색 | 3: 제품종류로 검색 | 4: 돌아가기");
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------");
			menu = sc.nextInt();
			sc.nextLine();
			
			if (menu < command.length) {
				command[menu].execute(sc);
			} else {
				isRun = false;
			}
		}

	}
}
