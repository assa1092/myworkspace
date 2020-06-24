package board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.domain.BoardDTO;
import share.Command;
import share.CommandAction;

public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String writer= request.getParameter("writer");
		String title= request.getParameter("title");
		String content= request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();

		// 답글이 아니라 모든게 0... 
		dao.insert(new BoardDTO(-1, writer, title, content, null, 0, 0, 0, 0));
		
		return new CommandAction(true, "boardlist.do");
	}

}
