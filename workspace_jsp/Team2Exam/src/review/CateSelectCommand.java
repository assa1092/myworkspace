package review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.ReviewDAO;
import review.PageTO;
import share.Command;
import share.CommandAction;

public class CateSelectCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		String category = request.getParameter("category");
		String scurPage = request.getParameter("curPage");
		int curPage = 1;
		if (scurPage != null) {
		  curPage = Integer.parseInt(scurPage);
		 }
		ReviewDAO dao = new ReviewDAO();
		PageTO to = dao.catepage(curPage, category);
		   // List<ReviewDTO> list = dao.list();
		request.setAttribute("list", to.getList());
		request.setAttribute("to", to);
		request.setAttribute("category", category);
		
		return new CommandAction(false, "reviewcategory.jsp");
		
		
		
	}

}
