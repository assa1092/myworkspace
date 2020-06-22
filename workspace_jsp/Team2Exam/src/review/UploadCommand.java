package review;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import share.Command;
import share.CommandAction;

public class UploadCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		String uploadPath = this.getClass().getResource("").getPath();
		uploadPath = uploadPath.substring(1, uploadPath.indexOf(".metadata")) 
				+ "Team2Exam" + File.separator + "WebContent" + File.separator + "upload" ;
		
		File uploadFolder = new File(uploadPath);
		if (!uploadFolder.exists()) {
			uploadFolder.mkdir();
		}
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath,10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		
		String sNum = multi.getParameter("num");
		int num = -1;
		if (sNum != null) {
			num = Integer.parseInt(sNum);
		}
		
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String id = multi.getParameter("id");
		String category = multi.getParameter("category");
		
		String sStarpoint = multi.getParameter("starpoint");
		int starpoint = -1;
		if (sStarpoint != null) {
			starpoint =  Integer.parseInt(sStarpoint);
		}
		String fileName = multi.getFilesystemName("file");
		String orgFileName = multi.getOriginalFileName("file");
		
		ReviewDAO dao = new ReviewDAO();
		
		dao.insert(new ReviewDTO(num, title, content, id, category, null, 0, starpoint), 
				new uploadDTO(fileName, orgFileName,num));
		
		
		return new CommandAction(true, "reviewlist.do");
	}

}



