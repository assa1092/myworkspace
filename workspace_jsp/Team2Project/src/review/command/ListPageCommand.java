package review.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.dao.ReviewDAO;
import review.domain.PageTO;
import review.domain.ReviewDTO;
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

		ReviewDAO dao = new ReviewDAO();
		PageTO to = dao.page(curPage);
		// 공지 데이터 바인딩
		ReviewDTO notice = dao.notice();
		// List<ReviewDTO> list = dao.list();
		request.setAttribute("list", to.getList());
		request.setAttribute("to", to);
		request.setAttribute("notice", notice);
		return new CommandAction(false, "reviewlist.jsp");
	}

}
