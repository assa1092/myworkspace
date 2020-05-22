package product.select;

import java.util.List;
import java.util.Scanner;

import product.com.naver.ProductDAO;
import product.com.naver.ProductDTO;
import product.kr.co.ca.ProductCommand;

public class SelectCommand implements ProductCommand {
	@Override
	public void execute(Scanner sc) {
		ProductDAO dao = new ProductDAO();
		List<ProductDTO> list = dao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
