package a;

import java.util.Scanner;

import com.naver.DB;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class InsertCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("���̵�");
		String id = sc.nextLine();
		
		System.out.println("�̸�");
		String name = sc.nextLine();
		
		System.out.println("����");
		int age = sc.nextInt();
		
		DB.db.add(new MemberDTO(id, name, age));
		
	}

}
