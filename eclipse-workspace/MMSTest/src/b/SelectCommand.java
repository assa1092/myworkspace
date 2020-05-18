package b;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class SelectCommand  implements Command{
	@Override
	public void execute(Scanner sc) {
		List<MemberDTO> list =  new ArrayList<MemberDTO>();
		
		MemberDAO dao = new MemberDAO();
		list = dao.selectAll();
		
		for(int i=0;i< list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
}
