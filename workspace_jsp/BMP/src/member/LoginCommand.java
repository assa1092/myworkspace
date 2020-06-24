package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import share.Command;
import share.CommandAction;

public class LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		boolean isLogin = dao.login(new LoginDTO(id, pw));
		
		if (isLogin) {
			HttpSession session = request.getSession();
			
			session.setAttribute("login", new LoginDTO(id, pw));
			return new CommandAction(false, "boardlist.do");
		} else {
			return new CommandAction(false, "memberloginui.do");
		}
		
	}

}
