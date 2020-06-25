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

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uploadPath = this.getClass().getResource("").getPath();
		uploadPath = uploadPath.substring(1, uploadPath.indexOf(".metadata")) + "Team2Project" + File.separator
				+ "WebContent" + File.separator + "boardupload";
		File uploadFolder = new File(uploadPath);
		if (! uploadFolder.exists()) {
			uploadFolder.mkdir();
		}
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, 10 * 1024 * 1024, "utf-8",
				new DefaultFileRenamePolicy());
		
		String sNum = multi.getParameter("num");
		int num =-1;
		if (sNum != null) {
			num = Integer.parseInt(sNum);
		}
		
		String writer = multi.getParameter("writer");
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO(num, writer, title, content, null, -1, -1, -1, -1);
	
		UploadDTO uploadDTO = dao.imgSelect(num);
		String newFileName = multi.getFilesystemName("file");
		
		String fileName = null;
		String orgFileName = null;
		if (newFileName != null) {
			
			fileName = uploadDTO.getFileName();
			String filePath = uploadPath + File.separator + fileName;
			orgFileName = multi.getOriginalFileName("file");
			
			File file = new File(filePath);
			
			if(file.exists()) {
				file.delete();
			}
		}
		
		dao.update(dto, new UploadDTO(fileName, orgFileName, num));
		
		return new CommandAction(true, "boardlist.do");
	}

}
