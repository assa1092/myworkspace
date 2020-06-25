package board.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.domain.BoardDTO;
import board.domain.PageTO;
import share.Command;
import share.CommandAction;

public class SearchCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		String scurPage = request.getParameter("curPage");
//		int curPage = 1;
//		if (scurPage != null) {
//		      curPage = Integer.parseInt(scurPage);
//		}
		
		String category = request.getParameter("category");
		String search = request.getParameter("search");
		List<BoardDTO> list = null;
		BoardDAO dao = new BoardDAO();
//		PageTO to = dao.searchPage(curPage, category);
		
		if (category.equals("title")) {
			list = dao.searchByTitle(search);
		} else if (category.equals("writer")) {
			list = dao.searchByWriter(search);
		} else if (category.equals("titlecontent")) {
			list = dao.searchByTitleContent(search);
		}
				
		request.setAttribute("list",list);
		
		return new CommandAction(false, "boardsearch.jsp");
	}

}
