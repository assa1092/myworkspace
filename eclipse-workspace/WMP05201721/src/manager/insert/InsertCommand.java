package manager.insert;

import java.util.Scanner;

import manager.com.naver.ManagerDAO;
import manager.com.naver.ManagerDTO;
import manager.kr.co.ca.ManagerCommand;

public class InsertCommand implements ManagerCommand{

	@Override
	public void execute(Scanner sc) {
		System.out.println("직원 아이디를 입력해주세요.");
		String mid = sc.nextLine();
		
		System.out.println("직원 이름을 입력해주세요.");
		String mname = sc.nextLine();
		
		System.out.println("직원의 부서를 입력해주세요.");
		String dept = sc.nextLine();
		
		ManagerDTO dto = new ManagerDTO(mid, mname, dept);
		ManagerDAO dao = new ManagerDAO();
		
		dao.insert(dto);
		
	}

}
