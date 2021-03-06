package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;


// Command 클래스에서 하는 일
// 1. 클라이언트가 보내준 데이터 획득및 가공.(숫자...)
// 2. DAO 객체 생성 및 해당 메소드 호출
// 3. 데이터 바인딩(pageContext, request, session, application).
// 4. 포워딩(dispatcher, redirect).

public class SelectByIdCommand implements Command {
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트가 보내준 데이터 획득및 가공.(숫자...)
		String id = request.getParameter("id");
		
		// 2. DAO 객체 생성 및 해당 메소드 호출
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectById(id);
		
		// 3. 데이터 바인딩(pageContext, request, session, application).
		request.setAttribute("dto", dto);
		
		// 4. 포워딩(dispatcher, redirect).
		// 데이터 값이 있으면 무조건 dispatcher...
		//request.getRequestDispatcher("selectById.jsp").forward(request, response);
		return new CommandAction(false, "selectById.jsp");
	}
}
