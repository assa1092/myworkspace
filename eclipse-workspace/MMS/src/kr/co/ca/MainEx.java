package kr.co.ca;

import com.naver.AccountDAO;
import com.naver.Process;

public class MainEx {
	public static void main(String[] args) {
		AccountDAO dao = new AccountDAO();
		
		dao.transfer("a", "b", 1000);	// transaction 상황 발생시키기
		
		new Process();
	}

}
