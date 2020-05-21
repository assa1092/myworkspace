package manager.com.naver;

import java.util.Scanner;

import manager.delete.DeleteCommand;
import manager.insert.InsertCommand;
import manager.kr.co.ca.ManagerCommand;
import manager.select.SelectCommand;
import manager.update.UpdateCommand;

public class Process {
	public Process() {
		ManagerCommand[] command = { new InsertCommand(), new SelectCommand(), new UpdateCommand(),
				new DeleteCommand() };

		boolean isTrue = true;
		int menu = -1;

		Scanner sc = new Scanner(System.in);

		while (isTrue) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.println(
					"------------------------------------------------------------------------------------------------------");
			System.out.println("0: 관리자 정보 입력 | 1: 관리자 정보 조회 |  2: 관리자 정보 수정 | 3: 관리자 정보 삭제 |  4: 돌아가기");
			System.out.println(
					"------------------------------------------------------------------------------------------------------");
			menu = sc.nextInt();
			sc.nextLine();

			if (menu < command.length) {
				command[menu].execute(sc);
			} else {
				isTrue = false;
			}
		}
		System.out.println("관리자 관리 종료");

	}
}
