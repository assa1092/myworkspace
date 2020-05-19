package product.com.naver;

import java.util.Scanner;

import product.delete.DeleteCommand;
import product.insert.InsertCommand;
import product.kr.co.ca.ProductCommand;
import product.select.SelectCommand;
import product.update.UpdateCommand;

public class Process {
	public Process() {
		ProductCommand[] productCommand = { new InsertCommand(), new SelectCommand(), new UpdateCommand(),
				new DeleteCommand() };
		int menu = -1;
		boolean isTrue = true;
		Scanner sc = new Scanner(System.in);
		while (isTrue) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.println("0: 물품 입력, 1: 물품 조회, 2: 물품 수정, 3: 물품 삭제, 4: 돌아가기");
			menu = sc.nextInt();
			sc.nextLine();
			if(menu == 4) {
				new main.MainProcess();
			}
			if (menu < productCommand.length) {
				productCommand[menu].execute(sc);
			} else {
				isTrue = false;
			}
		}
		sc.close();
	}
}
