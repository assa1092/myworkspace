package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import share.Command;
import share.CommandAction;

public class UpdateUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		LoginDTO sessionDTO=null;
		if (session !=null) {
			 sessionDTO = (LoginDTO) session.getAttribute("login");
			if (sessionDTO != null) {
				if (sessionDTO.getId().equals(id)) {
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
