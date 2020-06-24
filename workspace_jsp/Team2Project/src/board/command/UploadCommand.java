package board.command;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.dao.BoardDAO;
import board.domain.BoardDTO;
import board.domain.UploadDTO;
import share.Command;
import share.CommandAction;

public class UploadCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uploadPath = this.getClass().getResource("").getPath();
		uploadPath = uploadPath.substring(1, uploadPath.indexOf(".metadata")) + "Team2Project" + File.separator
				+ "WebContent" + File.separator + "boardupload";
		File uploadFolder = new File(uploadPath);
		if (!uploadFolder.exists()) {
			uploadFolder.mkdir();
		}
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		
		String writer = multi.getParameter("writer");
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		
		String fileName = multi.getFilesystemName("file");
		String orgFileName = multi.getOriginalFileName("file");
		
		BoardDAO dao = new BoardDAO();
	
		dao.insert(new BoardDTO(-1, writer, title, content, null, 0, 0, 0, 0), 
				new UploadDTO(fileName, orgFileName, -1));
		
		
		return new CommandAction(true, "boardlist.do");
	}

}
