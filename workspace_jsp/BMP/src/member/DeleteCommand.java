package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import share.Command;
import share.CommandAction;

public class DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			LoginDTO login = (LoginDTO) session.getAttribute("login");
			if (login != null) {
				String id = request.getParameter("id");
				if (login.getId().equals(id)) {
					MemberDAO dao = new MemberDAO();
					dao.delete(id);
					
					session.invalidate();
					
					return new CommandAction(true, "select.do");
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
