package review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import share.Command;
import share.CommandAction;

public class ListPageCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		String scurPage = request.getParameter("curPage");
		int curPage = 1;
		if (scurPage != null) {
			curPage = Integer.parseInt(scurPage);
		}
		
		ReviewDAO dao = new ReviewDAO();
		PageTO to = dao.page(curPage);
		
		ReviewDTO notice = dao.notice();
		
		request.setAttribute("list", to.getList());
		request.setAttribute("to", to);
		request.setAttribute("notice", notice);
		
		return new CommandAction(false, "reviewlist.jsp");
	}

}
