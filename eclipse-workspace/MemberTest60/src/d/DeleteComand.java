package d;

import java.util.Scanner;

import com.naver.DB;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class DeleteComand implements Command{

	@Override
	public void execute(Scanner sc) {
		System.out.println("���� id");
		String id = sc.nextLine();
		
		 boolean isMember = DB.db.remove(new MemberDTO(id, null, -1));
		 
		 if (isMember) {
			
			System.out.println("��������");
		}else {
			System.out.println("ȸ���ƴ�");
		}
		
	}

}
