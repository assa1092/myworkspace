package storage.delete;

import java.util.Scanner;
import storage.com.naver.StorageDAO;
import storage.kr.co.ca.StorageCommand;

public class DeleteCommand implements StorageCommand {
	@Override
	public void execute(Scanner sc) {
		System.out.println("삭제할 창고 아이디를 입력하세요");
		String sid = sc.nextLine();

		StorageDAO dao = new StorageDAO();
		dao.delete(sid);
	}
}
