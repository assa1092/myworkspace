package manager.delete;

import java.util.Scanner;

import manager.com.naver.ManagerDAO;
import manager.kr.co.ca.ManagerCommand;

public class DeleteCommand implements ManagerCommand{
	@Override
	public void execute(Scanner sc) {
		System.out.println("삭제할 직원 아이디를 입력해주세요.");
		String mid = sc.nextLine();
		
		ManagerDAO dao = new ManagerDAO();
		
		dao.delete(mid);
		
	}
}
