package product.delete;

import java.util.Scanner;

import product.com.naver.ProductDAO;
import product.kr.co.ca.ProductCommand;

public class DeleteCommand implements ProductCommand {
	@Override
	public void execute(Scanner sc) {
		System.out.println("삭제할 아이디를 넣어주세요.");
		String pid = sc.nextLine();
		ProductDAO dao = new ProductDAO();
		dao.delete(pid);
	}
}
