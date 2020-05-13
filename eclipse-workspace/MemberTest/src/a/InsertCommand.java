package a;

import java.util.List;
import java.util.Scanner;

import com.naver.DB;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class InsertCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		
		System.out.println("���̵� �Է��ϼ���.");
		String id =sc.nextLine();
		
		
		System.out.println("�̸��� �Է��ϼ���.");
		String name =sc.next();		// nextLine �� �ƴѰ��� ������ sc.nextLine();�߰�
		sc.nextLine();
		
		System.out.println("���̸� �Է��ϼ���.");
		int age = sc.nextInt();
		sc.nextLine();
		
		// MemberDTO ��ü�� ����� �ٽ� ���� �Է�
		MemberDTO dto =  new MemberDTO(id, name, age);
		DB.db.add(dto);
		
		// �� ������ �ѹ��� MemberDTO ��ü ���� �ٷ� ���� �Է�
		// DB.db.add(new MemberDTO(id, name, age));
	}

}
