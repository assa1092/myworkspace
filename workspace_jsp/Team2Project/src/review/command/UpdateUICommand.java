package review.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;
import member.domain.MemberDTO;
import review.dao.ReviewDAO;
import review.domain.ReviewDTO;
import review.domain.UploadDTO;
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

		

		

	String id = request.getParameter("id");
	HttpSession session = request.getSession();
	MemberDTO sessionDto = null;
	// 세션으로 아이디 검증
	if (session != null) {
		sessionDto = (MemberDTO) session.getAttribute("login");			
		if (sessionDto != null) {
			if (sessionDto.getId().equals(id)) {

				ReviewDAO dao = new ReviewDAO();
				ReviewDTO dto = dao.updateUI(num);
				UploadDTO udto = dao.imgSelect(num);
				request.setAttribute("dto", dto);
				request.setAttribute("udto", udto);
				return new CommandAction(false, "reviewupdate.jsp");

				
			} else {
				return new CommandAction(true, "notdelete.jsp");
			}			
		} else {
			return new CommandAction(true, "notdelete.jsp");
		}
	} else {
		return new CommandAction(true, "notdelete.jsp");
	}
}
}
