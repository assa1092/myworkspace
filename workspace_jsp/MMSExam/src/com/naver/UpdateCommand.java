package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String property = request.getParameter("property");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		dao.update(new MemberDTO(id, name, pw, property));
		
				
		return new CommandAction(false, "selectById.do?id="+ id);
	}

}
