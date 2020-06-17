package review.command;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.domain.MemberDTO;
import review.dao.ReviewDAO;
import review.domain.UploadDTO;
import share.Command;
import share.CommandAction;

public class DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			MemberDTO login = (MemberDTO) session.getAttribute("login");
			if (login != null) {
				String id = request.getParameter("id");

				// 아이디가 같은 경우 뿐 아니라 매니저나 어드민계정일 경우에도 삭제가 가능
				if (login.getId().equals(id)
						|| (login.getProperty().equals("admin") || login.getProperty().equals("manager"))) {

					String sNum = request.getParameter("num");
					int num = -1;
					if (sNum != null) {
						num = Integer.parseInt(sNum);
					}
					ReviewDAO dao = new ReviewDAO();
					String uploadPath = this.getClass().getResource("").getPath();
					uploadPath = uploadPath.substring(1, uploadPath.indexOf(".metadata")) + "Team2Project"
							+ File.separator + "WebContent" + File.separator + "upload";

					UploadDTO dto = dao.imgSelect(num);

					String fileName = dto.getFileName();

					String filePath = uploadPath + File.separator + fileName;

					File file = new File(filePath);

					if (file.exists())
						file.delete();
					dao.delete(num);
//					session.invalidate();

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
