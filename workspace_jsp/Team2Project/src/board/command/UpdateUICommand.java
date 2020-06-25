package board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.domain.BoardDTO;
import board.domain.UploadDTO;
import share.Command;
import share.CommandAction;

public class UpdateUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int num = -1;
		if (sNum != null) {
			num = Integer.parseInt(sNum);
		}
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.updateUI(num);
		UploadDTO udto = dao.imgSelect(num);
		
		request.setAttribute("dto", dto);
		request.setAttribute("udto", udto);
		
		return new CommandAction(false, "boardupdate.jsp");
	}

}
