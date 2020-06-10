package member.command;

import javax.naming.InitialContext;
import javax.security.auth.callback.ConfirmationCallback;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import member.dao.MemberDAO;
import member.domain.MemberDTO;
import share.Command;
import share.CommandAction;

public class GrantCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");
		String property = request.getParameter("property");
		HttpSession session = request.getSession();

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

//		if (property.equals("customer")) {
//			dao.grant(id, "manager");
//		}
//		if (property.equals("manager")) {
//			dao.grant(id, "customer");
//		}
//
//		return new CommandAction(true, "grantui.do");

	}

}
