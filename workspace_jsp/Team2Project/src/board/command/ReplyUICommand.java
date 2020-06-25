package board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import share.Command;
import share.CommandAction;

public class ReplyUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num = request.getParameter("num");
		
		return new CommandAction(false, "boardreply.jsp?num="+num);
	}

}
