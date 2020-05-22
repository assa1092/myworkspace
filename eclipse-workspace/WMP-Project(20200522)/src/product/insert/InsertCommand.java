package product.insert;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import product.com.naver.ProductDAO;
import product.com.naver.ProductDTO;
import product.kr.co.ca.ProductCommand;
import storage.com.naver.StorageDAO;
import storage.com.naver.StorageDTO;

public class InsertCommand implements ProductCommand {
	@Override
	public void execute(Scanner sc) {
		System.out.println("추가할 아이디를 입력하세요.");
		System.out.println("제품 아이디는 p로 시작하며 3자리 숫자로 이루어집니다.");
		System.out.println("ex) p001, p002 등");
		String pid = sc.nextLine();
		System.out.println("추가할 제품명을 입력하세요.");
		String pname = sc.nextLine();
		System.out.println("상품의 수량을 입력하세요.");
		int amount = sc.nextInt();
		sc.nextLine();
		System.out.println("상품의 가격을 입력하세요.");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.println("상품의 할인율을 입력하세요.");
		int discount = sc.nextInt();
		sc.nextLine();

		System.out.println("창고의 아이디를 입력해주세요.");
		System.out.println("현재 보유하고 있는 창고 리스트");
		StorageDAO sdao = new StorageDAO();
		List<StorageDTO> list = new ArrayList<StorageDTO>();
		list = sdao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		String sid = sc.nextLine();
		ProductDAO pdao = new ProductDAO();
		boolean isSid = pdao.selectSid(sid);
		if (isSid) {
			pdao.insert(new ProductDTO(pid, pname, amount, price, discount, sid));
		} else {
			System.out.println("잘못된 입력입니다. 창고 아이디 유무를 확인하세요.");
		}

	}
}
