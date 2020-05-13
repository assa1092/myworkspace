package c;

import java.util.Scanner;

import com.naver.DB;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class UpdateCommand  implements Command{

	@Override
	public void execute(Scanner sc) {
		System.out.println("수정할 id를 입력하세요.");
		String id = sc.nextLine();
		
		// equals재정의 할때 id 값으로만 동등성 비교처리 해놨음... 
		MemberDTO dto = new MemberDTO(id, null, -1);
		
		boolean isMember= DB.db.contains(dto);		// indexOf()로도 할수있다...
		
		if(isMember == true ) {	// if(isMember) 이렇게 사용을 많이함...
			System.out.println("이름을 입력하세요.");
			String name = sc.nextLine();
			
			System.out.println("나이를 입력하세요.");
			int age = sc.nextInt();
			sc.nextLine();
			
			dto.setName(name);
			dto.setAge(age);
			// db회원이 어디 있는지 알아야함
			int idx = DB.db.indexOf(dto);
			
			DB.db.set(idx, dto);
			
			
			
		}else {
			System.out.println("회원이 아닙니다.");
		}
		
	}

}
