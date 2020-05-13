package a;

import java.util.List;
import java.util.Scanner;

import com.naver.DB;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class InsertCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		
		System.out.println("아이디를 입력하세요.");
		String id =sc.nextLine();
		
		
		System.out.println("이름을 입력하세요.");
		String name =sc.next();		// nextLine 이 아닌경우는 무조건 sc.nextLine();추가
		sc.nextLine();
		
		System.out.println("나이를 입력하세요.");
		int age = sc.nextInt();
		sc.nextLine();
		
		// MemberDTO 객체를 만들고 다시 값을 입력
		MemberDTO dto =  new MemberDTO(id, name, age);
		DB.db.add(dto);
		
		// 위 두줄을 한번에 MemberDTO 객체 만들어서 바로 값을 입력
		// DB.db.add(new MemberDTO(id, name, age));
	}

}
