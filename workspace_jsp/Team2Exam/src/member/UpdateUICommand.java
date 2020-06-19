package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import share.Command;
import share.CommandAction;

public class UpdateUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		// 로그인한 상태에서 수정 삭제를 해야하기때문에 세션이용...
		HttpSession session = request.getSession();
		MemberDTO sessionDTO = null;	// 세션 확인을 위한 DTO
		
		String id = request.getParameter("id");
		
		if (session != null) {
			sessionDTO = (MemberDTO) session.getAttribute("login");
			if (sessionDTO != null) {
				if (sessionDTO.getId().equals(id)) {
					
					MemberDAO dao = new MemberDAO();
					MemberDTO dto = dao.updateUI(id);
					
					request.setAttribute("dto", dto);
					
					return new CommandAction(false, "memberupdate.jsp");
					
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
