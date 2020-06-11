package review.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.dao.ReviewDAO;
import review.domain.ReviewDTO;
import share.Command;
import share.CommandAction;

public class SearchCommand implements Command {
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String category = request.getParameter("category");
		String search = request.getParameter("search");
		List<ReviewDTO> list = null;
		ReviewDAO dao = new ReviewDAO();
		if (category.equals("title")) {
			list = dao.searchByTitle(search);
		} else if (category.equals("id")) {
			list = dao.searchById(search);
		} else if (category.equals("titlecontent")) {
			list = dao.searchByTitleContent(search);
		}
		request.setAttribute("list", list);
		return new CommandAction(false, "reviewsearch.jsp");
	}
}
