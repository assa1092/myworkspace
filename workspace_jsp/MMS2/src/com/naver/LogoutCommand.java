package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


// Command 클래스에서 하는 일
// 1. 클라이언트가 보내준 데이터 획득및 가공.(숫자...)
// 2. DAO 객체 생성 및 해당 메소드 호출
// 3. 데이터 바인딩.
// 4. 포워딩.

public class LogoutCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//		session
//		1. session : scope(시간, 브라우져)
//		 - 일정 시간이 지나면 세션은 유지 되지 않음.
//		 - 다른 브라우져에서는 세션이 유지 되지 않음.
//		2. session 시간 설정
//		 - setMaxInactiveInerval() 호출.
//		3. 로그 아웃 방법.
//		 - 세션시간을 0으로 설정하기.
//		 - 세션을 제거하기.
//		 - 세션에 바인딩된 데이터 제거하기
		
		
		// 세션 객체를 만들때는 request를 이용한다.
//		request.getSession();	  // 없으면 만들어서라도 넘겨달라는 의미
//		request.getSession(true); // 없으면 만들어서라도 넘겨달라는 의미
//		request.getSession(false);// 없으면 놔둬...의미
		HttpSession session = request.getSession();
		if(session != null) {
			// session.setMaxInactiveInterval(1);  // 세션시간을 0으로 설정하기.
			session.invalidate();		// 세션을 제거하기.
		}
			response.sendRedirect("select.do");
		

	}

}
