package d;

import java.util.Scanner;

import com.naver.MemberDAO;

import kr.co.ca.Command;

public class DeleteCommand implements Command{
	@Override
	public void execute(Scanner sc) {
		System.out.println("삭제할 아이디를 입력하세요.");
		String id = sc.nextLine();
		
		MemberDAO dao = new MemberDAO();
		
		dao.delete(id);
		
	}
}
