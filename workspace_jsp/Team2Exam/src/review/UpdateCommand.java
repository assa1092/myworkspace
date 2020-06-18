package review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDTO;
import share.Command;
import share.CommandAction;

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session !=null) {
			MemberDTO loginDTO = (MemberDTO) session.getAttribute("login");
			if (loginDTO !=null) {
				String id = request.getParameter("id");
				if (loginDTO.getId().equals(id)) {
					String sNum = request.getParameter("num");
					int num = -1;
					if (sNum != null) {
						num = Integer.parseInt(sNum);
					}
					String title = request.getParameter("title");
					String content = request.getParameter("content");

					String category = request.getParameter("category");

					String sStarpoint = request.getParameter("starpoint");
					int starpoint = -1;
					if (sStarpoint != null) {
						starpoint = Integer.parseInt(sStarpoint);
					}
					
					ReviewDAO dao = new ReviewDAO();
					dao.update(new ReviewDTO(num, title, content, null, category, null, 0, starpoint));
					
					return new CommandAction(true, "reviewlist.do");
					
				} else {
					return new CommandAction(true, "notdelete.jsp");
				}
			} else {
				return new CommandAction(true, "memberlogin.do");
			}
		} else {
			return new CommandAction(true, "memberlogin.do");
		}
	}

}
