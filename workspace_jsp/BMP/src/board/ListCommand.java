package board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import share.Command;
import share.CommandAction;

public class ListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.list();
		
		request.setAttribute("list", list);
		return new CommandAction(false, "boardlist.jsp");
	}

}
