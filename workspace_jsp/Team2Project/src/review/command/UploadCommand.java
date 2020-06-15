package review.command;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import review.dao.ReviewDAO;
import review.domain.ReviewDTO;
import review.domain.UploadDTO;
import share.Command;
import share.CommandAction;

public class UploadCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uploadPath = this.getClass().getResource("").getPath();
		uploadPath = uploadPath.substring(1, uploadPath.indexOf(".metadata")) + "Team2Project" + File.separator
				+ "WebContent" + File.separator + "upload";
		File uploadFolder = new File(uploadPath);
		if (!uploadFolder.exists()) {
			uploadFolder.mkdir();
		}

		MultipartRequest multi = new MultipartRequest(request, uploadPath, 10 * 1024 * 1024, "utf-8",
				new DefaultFileRenamePolicy());

		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String id = multi.getParameter("id");
		String category = multi.getParameter("category");

		String sStarpoint = multi.getParameter("starpoint");
		int starpoint = -1;
		if (sStarpoint != null) {
			starpoint = Integer.parseInt(sStarpoint);
		}
		String fileName = multi.getFilesystemName("file");
		String orgFileName = multi.getOriginalFileName("file");

		ReviewDAO dao = new ReviewDAO();
		dao.insert(new ReviewDTO(-1, title, content, id, category, null, 0, starpoint),
				new UploadDTO(fileName, orgFileName, -1));

		return new CommandAction(true, "reviewlist.do");
	}

}
