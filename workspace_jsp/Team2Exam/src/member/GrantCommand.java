package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import share.Command;
import share.CommandAction;

public class GrantCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String property = request.getParameter("property");
		HttpSession session = request.getSession();
		MemberDAO dao = new MemberDAO();
		
		if (session != null) {
			MemberDTO dto = (MemberDTO) session.getAttribute("login");
			if (dto != null) {
				if (dto.getProperty().equals("admin")) {
					
					if (property.equals("customer")) {
						dao.grant(id, "manager");
					}
					if (property.equals("manager")) {
						dao.grant(id, "customer");
					}
					return new CommandAction(true, "membergrantui.do");
				} else {
					return new CommandAction(true, "memberselect.do");
				}
				
			} else {
				return new CommandAction(true, "memberselect.do");
			}
		} else {
			return new CommandAction(true, "memberselect.do");
		}
		
	}

}
