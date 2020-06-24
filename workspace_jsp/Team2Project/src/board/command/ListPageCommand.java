package board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.domain.PageTO;
import share.Command;
import share.CommandAction;

public class ListPageCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String scurPage = request.getParameter("curPage");
		int curPage = 1;
		if (scurPage != null) {
			curPage = Integer.parseInt(scurPage);
		}
		
		BoardDAO dao = new BoardDAO();
		PageTO to = dao.page(curPage);
		
		
		request.setAttribute("list", to.getList());
		request.setAttribute("to", to);
			
		return new CommandAction(false, "boardlist.jsp");
	}

}
