package b;

import java.util.List;
import java.util.Scanner;

import com.naver.DB;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class SelectCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		List<MemberDTO> list = DB.db;
		
		for(int i=0; i < list.size(); i++) {
			MemberDTO dto = list.get(i);
			System.out.println(dto);
		}
		
//		for(int i=0; i<DB.db.size(); i++) {
//			MemberDTO dto = DB.db.get(i);
//			System.out.println(dto.getId());
//			System.out.println(dto.getName());
//			System.out.println(dto.getAge());
//		}
		// i값을 줄여주면서...
		// for(int i= DB.db.size(); i >=0; i--) 
		
	}

}
