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

public class CateSelectCommand implements Command{

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String category = request.getParameter("category");
		List<ReviewDTO> list = null;
		ReviewDAO dao = new ReviewDAO();
		
		list = dao.cateSelect(category);
		request.setAttribute("category", category);
		request.setAttribute("list", list);
		return new CommandAction(false, "reviewcategory.jsp");
	}

	
	
}
