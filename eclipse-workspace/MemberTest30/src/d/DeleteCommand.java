package d;

import java.util.Scanner;

import com.naver.DB;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class DeleteCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		System.out.println("������ id�� �Է��ϼ���.");
		String id = sc.nextLine();
		
		boolean isOk = DB.db.remove(new MemberDTO(id, null, -1));
				
		if(isOk) {
			System.out.println("ȸ�� Ż�� ����");
		}else {
			System.out.println("ȸ���� �ƴմϴ�.");
		}
		
	}

}
