package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListPageCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String scurPage = request.getParameter("curPage");
		int curPage= 1;
		if (scurPage != null) {
			curPage = Integer.parseInt(scurPage);
		}
		
		BoardDAO dao = new BoardDAO();
		PageTO to = dao.page(curPage);
		
		request.setAttribute("to", to);
		request.setAttribute("list", to.getList());
		
		
		return new CommandAction(false, "list.jsp");
	}

}
