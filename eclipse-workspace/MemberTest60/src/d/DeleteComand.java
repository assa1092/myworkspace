package d;

import java.util.Scanner;

import com.naver.DB;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class DeleteComand implements Command{

	@Override
	public void execute(Scanner sc) {
		System.out.println("삭제 id");
		String id = sc.nextLine();
		
		 boolean isMember = DB.db.remove(new MemberDTO(id, null, -1));
		 
		 if (isMember) {
			
			System.out.println("삭제성공");
		}else {
			System.out.println("회원아님");
		}
		
	}

}
