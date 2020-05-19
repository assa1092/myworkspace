package manager.com.naver;

import java.util.Scanner;

import manager.delete.DeleteCommand;
import manager.insert.InsertCommand;
import manager.kr.co.ca.ManagerCommand;
import manager.select.SelectCommand;
import manager.update.UpdateCommand;

public class Process {
	public Process() {
		ManagerCommand[] command = {new InsertCommand(), new SelectCommand(),
									new UpdateCommand(), new DeleteCommand()};
		
		boolean isTrue = true;
		int menu = -1;
		
		Scanner sc = new Scanner(System.in);
		
		while (isTrue) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.println("0. 직원 정보 입력, 1. 직원 정보 조회, 2.직원 정보 수정, 3. 직원 정보 삭제, 4. 돌아가기");
			menu = sc.nextInt();
			sc.nextLine();
			if (menu ==4) {
				new main.MainProcess();
			}	
			
			if (menu < command.length) {
				command[menu].execute(sc);
			} else {
				isTrue = false;
			}
		}		
		System.out.println("프로그램 종료");
		sc.close();
	}
}
