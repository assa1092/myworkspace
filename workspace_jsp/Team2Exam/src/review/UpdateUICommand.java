package review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDTO;
import share.Command;
import share.CommandAction;

public class UpdateUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int num = -1;
		if (sNum != null) {
			num = Integer.parseInt(sNum);
		}
		
		// 같은 아이디만 수정가능하게 하기위해 ... 아이디로 같이 가져왔다.
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		MemberDTO sessionDTO = null;
		// 세션으로 아이디 검증...
		
		if (session != null) {
			sessionDTO = (MemberDTO) session.getAttribute("login");
			if (sessionDTO != null) {
				if (sessionDTO.getId().equals(id)) {
					// 아이디 검증 완료.
					ReviewDAO dao = new ReviewDAO();
					// 게시글 번호로 수정할 내용을 찾아온다... 
					ReviewDTO dto = dao.updateUI(num);	
					
					request.setAttribute("dto", dto);
					
					return new CommandAction(false, "reviewupdate.jsp");
							
				} else {
					System.out.println("1차");
					return new CommandAction(true, "notdelete.jsp");
				}
			} else {
				System.out.println("2차");
				return new CommandAction(true, "notdelete.jsp");
			}
		} else {
			System.out.println("3차");
			return new CommandAction(true, "notdelete.jsp");
		}
		
		
	}

}
