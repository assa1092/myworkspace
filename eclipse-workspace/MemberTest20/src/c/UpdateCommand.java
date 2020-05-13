package c;

import java.util.Scanner;

import com.naver.DB;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class UpdateCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("������ id�� �Է��ϼ���.");
		String id = sc.nextLine();
		
		MemberDTO dto = new MemberDTO(id, null, -1);
		
		boolean isMember= DB.db.contains(dto);
		
		if(isMember) {
			System.out.println(" �̸��� �Է��ϼ���.");
			String name = sc.nextLine();
			
			System.out.println(" ���̸� �Է��ϼ���.");
			int age = sc.nextInt();
			sc.nextLine();
			
			dto.setAge(age);
			dto.setName(name);
			
			int idx= DB.db.indexOf(dto);
			
			DB.db.set(idx, dto);
			
		}else {
			System.out.println("ȸ���� �ƴմϴ�.");
		}
		
		
		
	}

}
