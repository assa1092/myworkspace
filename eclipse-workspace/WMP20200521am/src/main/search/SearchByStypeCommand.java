package main.search;

import java.util.List;
import java.util.Scanner;

import main.MainCommand;

public class SearchByStypeCommand implements MainCommand{
	@Override
	public void execute(Scanner sc) {

		System.out.println("검색할 물품 목록를 입력하세요.");
		String stype = sc.nextLine();
		
		SearchDAO sdao = new SearchDAO();
				
		List<WmpDTO> list  = sdao.searchByStype(stype);
		
		for(int i=0; i< list.size();i++) {
			System.out.println("=======================================");
			System.out.println("물품종류  : "+list.get(i).getStype());
			System.out.println("제품이름  : "+list.get(i).getPname());
			System.out.println("수   량   : "+list.get(i).getAmount());
			System.out.println("가   격   : " + list.get(i).getPrice());
			System.out.println("창고위치  : " +list.get(i).getLocation());
			System.out.println("관리자    : "+list.get(i).getMname());
			System.out.println("부  서    : "+list.get(i).getDept());
			System.out.println("=======================================");
		}		
		
	}
}
