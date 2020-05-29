package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Command 클래스에서 하는 일
		// 1. 클라이언트가 보내준 데이터 획득및 가공.(숫자...)
		// 2. DAO 객체 생성 및 해당 메소드 호출
		// 3. 데이터 바인딩(pageContext, request, session, application).
		// 4. 포워딩(dispatcher, redirect).
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		boolean isLogin = new MemberDAO().login(new LoginDTO(id,pw));
		
		if (isLogin) { // 정상 로그인
			HttpSession session = request.getSession();
			session.setAttribute("login",new LoginDTO(id, null));
			return new CommandAction(true, "select.bo");
		} else {
			return new CommandAction(true, "loginui.bo");
		}
	}

}
