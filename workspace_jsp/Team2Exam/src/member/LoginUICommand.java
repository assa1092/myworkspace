package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import share.Command;
import share.CommandAction;

public class LoginUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		
		return new CommandAction(false, "memberlogin.jsp");
	}

}
