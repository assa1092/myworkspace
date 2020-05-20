package storage.insert;

import java.util.Scanner;
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

		System.out.println("창고 관리자 아이디를 입력하세요.");
		String mid = sc.nextLine();

		StorageDTO dto = new StorageDTO(sid, location, stype, mid);
		StorageDAO dao = new StorageDAO();

		dao.insert(dto);
	}
}
