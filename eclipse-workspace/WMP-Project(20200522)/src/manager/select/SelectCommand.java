package manager.select;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import manager.com.naver.ManagerDAO;
import manager.com.naver.ManagerDTO;
import manager.kr.co.ca.ManagerCommand;

public class SelectCommand implements ManagerCommand{
	@Override
	public void execute(Scanner sc) {
		List<ManagerDTO> list = new ArrayList<ManagerDTO>();
		
		ManagerDAO dao = new ManagerDAO();
		list = dao.selectAll();
		
		for(int i=0;i<list.size();i ++) {
			System.out.println(list.get(i));
		}
		
	}
}
