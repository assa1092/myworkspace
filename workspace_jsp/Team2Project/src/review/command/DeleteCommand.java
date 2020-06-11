package review.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.domain.MemberDTO;
import review.dao.ReviewDAO;
import share.Command;
import share.CommandAction;

public class DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			MemberDTO login = (MemberDTO) session.getAttribute("login");
			if (login != null) {
				String id = request.getParameter("id");

				if (login.getId().equals(id)) {
					String sNum = request.getParameter("num");
					int num = -1;
					if (sNum != null) {
						num = Integer.parseInt(sNum);
					}
					ReviewDAO dao = new ReviewDAO();

					dao.delete(num);
//					session.invalidate();

					return new CommandAction(true, "reviewlist.do");
				} else {
					return new CommandAction(true, "memberlogin.do");
				}
			} else {
				return new CommandAction(true, "memberlogin.do");
			}
		} else {
			return new CommandAction(true, "memberlogin.do");
		}
	}

}
