package b;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class SelectByNameCommand implements Command {
	@Override
	public void execute(Scanner sc) {
		System.out.println("검색할 이름을 입력하세요.");
		String name = sc.nextLine();
		
		List<MemberDTO> list =  new ArrayList<MemberDTO>();
		MemberDAO dao = new MemberDAO();
		list = dao.selectByName(name);
		
		for (int i=0; i < list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}
}
