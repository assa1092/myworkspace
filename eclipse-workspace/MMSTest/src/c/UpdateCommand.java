package c;

import java.util.Scanner;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class UpdateCommand implements Command {
	@Override
	public void execute(Scanner sc) {
		System.out.println("수정할 아이디를 입력하세요.");
		String id = sc.nextLine();
		
		System.out.println("이름를 입력하세요.");
		String name  = sc.nextLine();
		
		System.out.println("나이를 입력하세요.");
		int age = sc.nextInt();
		
		MemberDTO dto = new MemberDTO(id, name, age);
		MemberDAO dao = new MemberDAO();
		dao.update(dto);
		
	}
}
