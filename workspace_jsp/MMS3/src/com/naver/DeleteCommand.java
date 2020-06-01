package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Command 클래스에서 하는 일
		// 1. 클라이언트가 보내준 데이터 획득및 가공.(숫자...)
		// 2. DAO 객체 생성 및 해당 메소드 호출
		// 3. 데이터 바인딩.
		// 4. 포워딩.
		
		
		//로그인이 안되있으면 삭제 안되게...
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			
			LoginDTO login = (LoginDTO) session.getAttribute("login");
			
			if (login != null) {
				String id = request.getParameter("id");
				
				if (login.getId().equals(id)) {
				// 로그인 했던 아이디하고 
				// 삭제하려는 아이디하고 같으면 삭제...아니면 로그인 화면...
				// m001 로 로그인해서 m003을 삭제하려고 하면 안된다...	
					MemberDAO dao = new MemberDAO();
					dao.delete(id);
					
					// 삭제후 로그아웃...
					session.invalidate();
					
					return new CommandAction(true, "select.bo");
					
				} else {	//로그인 했던 아이디와 삭제하려는 아이디가 다르면 로그인 화면...
					return new CommandAction(true, "login.bo");
				}
				
			}else { // 로그인이 안되어있으면 로그인 화면으로..
				return new CommandAction(true, "login.bo");
			}
		} else {
			// 세션이 있으면 로그인 되었을 가능이 있다. 
			// 없으면 무조건 로그인이 안된상태... 로그인 하고 와...
			return new CommandAction(true, "login.bo");
		}
		
	}

}
