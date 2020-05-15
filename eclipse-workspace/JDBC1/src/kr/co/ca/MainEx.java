package kr.co.ca;

import com.naver.MemberDTO;
import com.naver.TestDAO;

public class MainEx {
	public static void main(String[] args) {
		TestDAO dao = new TestDAO();
		
		//dao.insert(new MemberDTO());
		//dao.selectAll();
		//dao.update(new MemberDTO());
		//dao.delete(1);
		MemberDTO dto = new MemberDTO("m001", "kim",1);
		dao.insert(dto);
	}

}
