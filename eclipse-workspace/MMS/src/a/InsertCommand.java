package a;

import java.util.Scanner;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class InsertCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		System.out.println("���̵� �Է��ϼ���");
		String id = sc.nextLine();
		
		System.out.println("�̸��� �Է��ϼ���.");
		String name = sc.nextLine();
		
		System.out.println("���̸� �Է��ϼ���.");
		int age = sc.nextInt();
		sc.nextLine();
		
		// �̷��� �ص� ��...
//		String sAge =  sc.nextLine();
//		int age = Integer.parseInt(sAge);
		
		MemberDTO dto = new MemberDTO(id, name, age);
		
		MemberDAO dao = new MemberDAO();
		dao.insert(dto);		// ������ DB.db.add()
		
		
	}

}