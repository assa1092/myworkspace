package a;

import java.util.Scanner;

import com.naver.DB;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class InsertCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		System.out.println("���̵� �Է��ϼ���.");
		String id = sc.nextLine();
		
		System.out.println("�̸��� �Է��ϼ���.");
		String name = sc.nextLine();
		
		System.out.println("���̸� �Է��ϼ���.");
		int age = sc.nextInt();
		sc.nextLine();
		
		DB.db.add(new MemberDTO(id, name, age));
		
		
	}

}
