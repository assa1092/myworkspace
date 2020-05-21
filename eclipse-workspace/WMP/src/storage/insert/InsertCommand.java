package storage.insert;

import java.util.List;
import java.util.Scanner;

import manager.com.naver.ManagerDAO;
import manager.com.naver.ManagerDTO;
import product.com.naver.ProductDTO;
import storage.com.naver.StorageDAO;
import storage.com.naver.StorageDTO;
import storage.kr.co.ca.StorageCommand;

public class InsertCommand implements StorageCommand {
	@Override
	public void execute(Scanner sc) {
		System.out.println("추가할 창고 아이디를 입력하세요.");
		System.out.println("창고 아이디는 s로 시작하며 3자리 숫자로 이루어집니다.");
		System.out.println("ex) s001, s002 등");
		String sid = sc.nextLine();

		System.out.println("창고 위치를 입력하세요.");
		String location = sc.nextLine();

		System.out.println("창고 제품종류를 입력하세요.");
		String stype = sc.nextLine();

		System.out.println("창고 관리자 아이디를 입력하세요.");
		System.out.println("관리자 리스트");
		ManagerDAO mdao = new ManagerDAO();
		List<ManagerDTO> list = mdao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		String mid = sc.nextLine();

		StorageDAO sdao = new StorageDAO();
		boolean isMid = sdao.selectMid(mid);
		if (isMid) {
			sdao.insert(new StorageDTO(sid, location, stype, mid));
		} else {
			System.out.println("잘못된 입력입니다. 관리자 아이디 유무를 확인하세요.");
		}

	}
}
