package review.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.dao.ReviewDAO;
import review.domain.ReviewDTO;
import share.Command;
import share.CommandAction;

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int num = -1;
		if (sNum != null) {
			num = Integer.parseInt(sNum);
		}

		String title = request.getParameter("title");
		String id = request.getParameter("id");
		String category = request.getParameter("category");
		String sStarpoint = request.getParameter("starpoint");
		int starpoint = -1;
		if (sStarpoint != null) {
			starpoint = Integer.parseInt(sStarpoint);
		}
		String content = request.getParameter("content");

		ReviewDAO dao = new ReviewDAO();
		dao.update(new ReviewDTO(num, title, content, id, category, null, -1, starpoint));

		return new CommandAction(true, "reviewlist.do");
	}

}
