package c;

import java.util.Scanner;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class UpdateCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("수정할 아이디를 입력하세요");
		String id = sc.nextLine();
		
		System.out.println("이름을 입력하세요.");
		String name = sc.nextLine();
		
		System.out.println("나이를 입력하세요");
		int age = sc.nextInt();
		sc.nextLine();
		
		MemberDTO dto = new MemberDTO(id, name, age);
		
		MemberDAO dao = new MemberDAO();	//  update를 쓸려면 필요
		dao.update(dto);
		
	}

}
