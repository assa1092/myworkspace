package storage.select;

import java.util.List;
import java.util.Scanner;
import storage.com.naver.StorageDAO;
import storage.com.naver.StorageDTO;
import storage.kr.co.ca.StorageCommand;

public class SelectCommand implements StorageCommand {
	@Override
	public void execute(Scanner sc) {
		StorageDAO dao = new StorageDAO();
		List<StorageDTO> list = dao.selectAll();

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
