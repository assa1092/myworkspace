package d;

import java.util.Scanner;

import com.naver.MemberDAO;

import kr.co.ca.Command;

public class DeleteCommand implements Command{
	@Override
	public void execute(Scanner sc) {
		System.out.println("������ ���̵� �Է��ϼ���.");
		String id = sc.nextLine();
		
		MemberDAO dao = new MemberDAO();
		
		dao.delete(id);
		
	}
}
