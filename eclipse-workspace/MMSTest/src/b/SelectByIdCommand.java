package b;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class SelectByIdCommand implements Command{
	@Override
	public void execute(Scanner sc) {
		System.out.println("검색할 아이디를 입력하세요.");
		String id = sc.nextLine();
		
		
		MemberDTO dto = new MemberDTO();
		MemberDAO dao =  new MemberDAO();
		dto = dao.selectById(id);
		System.out.println("ID: "+dto.getId());
		System.out.println("이름: "+ dto.getName());
		System.out.println("나이: " + dto.getAge());
		
		
		
	}
}
