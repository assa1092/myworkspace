package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import share.Command;
import share.CommandAction;

public class DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			MemberDTO sessionDTO = (MemberDTO) session.getAttribute("login");
			
			if (sessionDTO != null) {
				String id =  request.getParameter("id");
				
				if (sessionDTO.getId().equals(id)) {
					MemberDAO dao = new MemberDAO();
					
					dao.delete(id);
					
					
					session.invalidate();
					return new CommandAction(true, "memberlist.do");
					
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
