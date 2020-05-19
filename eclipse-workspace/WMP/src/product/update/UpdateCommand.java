package product.update;

import java.util.Scanner;

import product.com.naver.ProductDAO;
import product.com.naver.ProductDTO;
import product.kr.co.ca.ProductCommand;

public class UpdateCommand implements ProductCommand {
	@Override
	public void execute(Scanner sc) {
		System.out.println("수정할 아이디를 입력하세요.");
		String pid = sc.nextLine();
		System.out.println("수정할 제품명을 입력하세요.");
		String pname = sc.nextLine();
		System.out.println("수정할 수량을 입력하세요.");
		int amount = sc.nextInt();
		sc.nextLine();
		System.out.println("수정할 가격을 입력하세요.");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.println("수정할 할인율을 입력하세요.");
		int discount = sc.nextInt();
		sc.nextLine();
		System.out.println("수정할 창고 아이디를 입력하세요.");
		String sid = sc.nextLine();

		ProductDAO dao = new ProductDAO();
		dao.update(new ProductDTO(pid, pname, amount, price, discount, sid));
	}
}
