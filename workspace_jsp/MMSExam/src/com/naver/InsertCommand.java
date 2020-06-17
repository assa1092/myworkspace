package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String property = request.getParameter("property");
		
		MemberDAO dao = new MemberDAO();
		dao.insert(new MemberDTO(id, name, pw, property));
		
		
		return new CommandAction(true, "select.do");
	}

}
