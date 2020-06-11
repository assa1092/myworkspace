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

public class UpdateUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		MemberDTO sessionDto = null;
		if (session != null) {
			sessionDto = (MemberDTO) session.getAttribute("login");			
			if (sessionDto != null) {
				if (sessionDto.getId().equals(id)) {

					MemberDAO dao = new MemberDAO();
					MemberDTO dto = dao.updateUI(id);
					
					request.setAttribute("dto", dto);
					
					return new CommandAction(false, "memberupdate.jsp");

					
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
