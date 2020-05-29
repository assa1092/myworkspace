package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectCommand implements Command {
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		// Command 클래스에서 하는 일
		// 1. 클라이언트가 보내준 데이터 획득및 가공.(숫자...)
		// 2. DAO 객체 생성 및 해당 메소드 호출
		// 3. 데이터 바인딩(pageContext, request, session, application).
		// 4. 포워딩(dispatcher, redirect).
		
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.selectAll();
		
		// 3. 데이터 바인딩(pageContext, request, session, application).
		request.setAttribute("list", list);
		
		// 4. 포워딩(dispatcher, redirect).
		// 리다이렉트로 보내면 데이터가 없어진다...
		
//		request.getRequestDispatcher("select.jsp").forward(request, response);
		return new CommandAction(false, "select.jsp");
	}
}
