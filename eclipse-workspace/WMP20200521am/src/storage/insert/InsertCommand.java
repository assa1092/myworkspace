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
		String sid = sc.nextLine();

		System.out.println("창고 위치를 입력하세요.");
		String location = sc.nextLine();

		System.out.println("창고 관리물품을 입력하세요.");
		String stype = sc.nextLine();

		ManagerDAO mdao = new ManagerDAO();
		List<ManagerDTO> list = mdao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("창고 관리자 아이디를 입력하세요.");
		String mid = sc.nextLine();

		StorageDAO sdao = new StorageDAO();
		boolean isMid = sdao.selectMid(mid);
		if (isMid) {
			sdao.insert(new StorageDTO(sid, location, stype, mid));
		} else {
			System.out.println("잘못된 입력입니다.");
		}

	}
}
