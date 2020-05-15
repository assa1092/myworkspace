package b;

import java.util.List;
import java.util.Scanner;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class SelectCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list =  dao.selectAll();
		
		for (int i=0; i < list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}

}
