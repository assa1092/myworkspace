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

public class DeleteCommand implements Command{
	// delete 는 바로 삭제되니 다른것이 필요없다...
	@Override
	public void execute(HttpServletRequest request, 
							HttpServletResponse response) 
			throws ServletException, IOException {
		// 1. 클라이언트가 보내준 데이터 획득및 가공.(숫자...)
		String id = request.getParameter("id");

		// 로그인이 되어있으면 삭제...
		// 로그인이 안되어있으면 로그인 화면으로...

		// 먼저 세션을 가져온다.
		// 세션 객체를 만들때는 request를 이용한다.
		// request.getSession(false);// 없으면 놔둬...의미
		HttpSession session = request.getSession(false);

		if (session != null) { // 세션이 있으면 로그인 되었을 가능이 있다. 없으면 무조건 로그인이 안된상태...
			LoginDTO loginDTO = (LoginDTO) session.getAttribute("login");

			if (loginDTO != null) { 
				
				// 로그인 했던 아이디하고 
				// 삭제하려는 아이디하고 같으면 삭제...아니면 로그인 화면...
				if (loginDTO.getId().equals(id)) { 
					MemberDAO dao = new MemberDAO();
					
					dao.delete(id);
					response.sendRedirect("select.do");
				} else {
					response.sendRedirect("loginui.do");
				}

			} else {
				response.sendRedirect("loginui.do");
			}

		} else {// 세션이 있으면 로그인 되었을 가능이 있다. 없으면 무조건 로그인이 안된상태... 로그인 하고 와...
			response.sendRedirect("loginui.do");
		}

		// 2. DAO 객체 생성 및 해당 메소드 호출

		// 3. 데이터 바인딩(pageContext, request, session, application).
		// 바인딩 할것 없음.

		// 4. 포워딩(dispatcher, redirect).

		// 기존에 있던 delete 기능...
//		MemberDAO dao = new MemberDAO();
//		dao.delete(id);
//		
//		response.sendRedirect("select.do");

	}
}
