package member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;
import member.domain.MemberDTO;
import share.Command;
import share.CommandAction;

public class DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		MemberDTO dto = null;
		if (session != null) {
			dto = (MemberDTO) session.getAttribute("login");			
			if (dto != null) {
				String id = request.getParameter("id");
				if (dto.getId().equals(id)) {
					MemberDAO dao = new MemberDAO();
					dao.delete(id);
					session.invalidate();
					return new CommandAction(true, "reviewlist.do");
				} else {
					return new CommandAction(true, "memberloginui.do");
				}			
			} else {
				return new CommandAction(true, "memberloginui.do");
			}
		} else {
			return new CommandAction(true, "memberloginui.do");
		}
	}

}