package board.command;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.domain.UploadDTO;
import share.Command;
import share.CommandAction;

public class DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum  = request.getParameter("num");
		int num = -1;
		if (sNum != null) {
			num = Integer.parseInt(sNum);
		}
		
		BoardDAO dao = new BoardDAO();
		String uploadPath = this.getClass().getResource("").getPath();
		uploadPath = uploadPath.substring(1, uploadPath.indexOf(".metadata")) + "Team2Project"
				+ File.separator + "WebContent" + File.separator + "boardupload";
		
		UploadDTO dto = dao.imgSelect(num);
		
		String fileName = dto.getFileName();
		String filePath = uploadPath + File.separator + fileName;
		
		File file = new File(filePath);
		
		if (file.exists()) {
			file.delete();
		}
		dao.delete(num);
		
		return new CommandAction(true, "boardlist.do");
	}

}
