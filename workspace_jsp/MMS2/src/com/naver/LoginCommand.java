package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.dao.MemberDAO;
import kr.co.domain.LoginDTO;


// Command 클래스에서 하는 일
// 1. 클라이언트가 보내준 데이터 획득및 가공.(숫자...)
// 2. DAO 객체 생성 및 해당 메소드 호출
// 3. 데이터 바인딩(pageContext, request, session, application).
// 4. 포워딩(dispatcher, redirect).

public class LoginCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트가 보내준 데이터 획득및 가공.(숫자...)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// DB 에 데이터가 있는지 먼저 확인해야
		
		// 2. DAO 객체 생성 및 해당 메소드 호출
		MemberDAO dao = new MemberDAO();
		boolean login = dao.login(new LoginDTO(id,pw));

		// 세션 객체를 만들때는 request를 이용한다.
//		request.getSession();	  // 없으면 만들어서라도 넘겨달라는 의미
//		request.getSession(true); // 없으면 만들어서라도 넘겨달라는 의미
//		request.getSession(false);// 없으면 놔둬...의미
		
		if(login) {	// 로그인이 성공하면... 목록으로 이동
			HttpSession session = request.getSession();		//request에서 session을 가져오는것...
			// session 자체의 존재여부가 아니라 session 의 값이 있어야만 가능...
			
			// session이 유지되는 시간 30초로 설정
			session.setMaxInactiveInterval(60);
			session.setAttribute("login", new LoginDTO(id, null));
			response.sendRedirect("select.do");		
		} else {	// 로그인이 실패하면  로그인 화면으로 이동
			response.sendRedirect("loginui.do");	
		}
		
		
		// 3. 데이터 바인딩(pageContext, request, session, application).
		
		
		
		// 4. 포워딩(dispatcher, redirect).
		
	}

}
