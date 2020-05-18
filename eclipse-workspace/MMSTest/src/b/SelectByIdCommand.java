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
		System.out.println("�˻��� ���̵� �Է��ϼ���.");
		String id = sc.nextLine();
		
		
		MemberDTO dto = new MemberDTO();
		MemberDAO dao =  new MemberDAO();
		dto = dao.selectById(id);
		System.out.println("ID: "+dto.getId());
		System.out.println("�̸�: "+ dto.getName());
		System.out.println("����: " + dto.getAge());
		
		
		
	}
}
