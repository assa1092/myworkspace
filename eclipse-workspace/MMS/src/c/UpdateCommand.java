package c;

import java.util.Scanner;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class UpdateCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("������ ���̵� �Է��ϼ���");
		String id = sc.nextLine();
		
		System.out.println("�̸��� �Է��ϼ���.");
		String name = sc.nextLine();
		
		System.out.println("���̸� �Է��ϼ���");
		int age = sc.nextInt();
		sc.nextLine();
		
		MemberDTO dto = new MemberDTO(id, name, age);
		
		MemberDAO dao = new MemberDAO();	//  update�� ������ �ʿ�
		dao.update(dto);
		
	}

}
