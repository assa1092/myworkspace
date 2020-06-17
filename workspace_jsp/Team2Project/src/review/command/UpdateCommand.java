package review.command;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.domain.MemberDTO;
import review.dao.ReviewDAO;
import review.domain.ReviewDTO;
import review.domain.UploadDTO;
import share.Command;
import share.CommandAction;

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			MemberDTO login = (MemberDTO) session.getAttribute("login");
			if (login != null) {
				// 수정 시 파일을 올리기 위한 기본 환경설정
				String uploadPath = this.getClass().getResource("").getPath();
				uploadPath = uploadPath.substring(1, uploadPath.indexOf(".metadata")) + "Team2Project" + File.separator
						+ "WebContent" + File.separator + "upload";
				File uploadFolder = new File(uploadPath);

				if (!uploadFolder.exists()) {
					uploadFolder.mkdir();
				}

				MultipartRequest multi = new MultipartRequest(request, uploadPath, 10 * 1024 * 1024, "utf-8",
						new DefaultFileRenamePolicy());
				// request로 값을 받으면 사용할 수 없으므로 multi로 받는다.

				String id = multi.getParameter("id");

				if (login.getId().equals(id)) {
					// 새로 수정하는 파일 이름
					String newFileName = multi.getFilesystemName("file");
					String sNum = multi.getParameter("num");
					int num = -1;
					if (sNum != null) {
						num = Integer.parseInt(sNum);
					}
					String title = multi.getParameter("title");
					String content = multi.getParameter("content");

					String category = multi.getParameter("category");

					String sStarpoint = multi.getParameter("starpoint");
					int starpoint = -1;
					if (sStarpoint != null) {
						starpoint = Integer.parseInt(sStarpoint);
					}

					// 수정 시 기존 파일 삭제 후 덮어쓰기
					ReviewDAO dao = new ReviewDAO();
					UploadDTO dto = dao.imgSelect(num);

					String fileName = null;
					String orgFileName = null;

					if (newFileName != null) {
						// 기존의 파일 이름
						fileName = dto.getFileName();

						String filePath = uploadPath + File.separator + fileName;
						orgFileName = multi.getOriginalFileName("file");

						File file = new File(filePath);

						// 기존 파일 삭제
						if (file.exists()) {
							file.delete();
						}
					}
					// 수정
					dao.update(new ReviewDTO(num, title, content, null, category, null, 0, starpoint),
							new UploadDTO(newFileName, orgFileName, num));

					return new CommandAction(true, "reviewlist.do");
				} else {

					return new CommandAction(true, "notdelete.jsp");
				}
			} else {

				return new CommandAction(true, "memberlogin.do");
			}
		} else {

			return new CommandAction(true, "memberlogin.do");
		}
	}

}
