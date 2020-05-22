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
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("0: 제품 추가 | 1: 제품 조회 | 2: 제품 수정 | 3: 제품 삭제 | 4: 돌아가기");
			System.out.println("-------------------------------------------------------------------------");
			menu = sc.nextInt();
			sc.nextLine();
			if (menu < productCommand.length) {
				productCommand[menu].execute(sc);
			} else {
				isTrue = false;
			}
		}
		System.out.println("제품 관리 종료");
	}
}
