package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import share.Command;
import share.CommandAction;

public class LogoutCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse reponse)
		
			throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);
		
		session.invalidate();
		return new CommandAction(true, "reviewlist.do");
	}

}
