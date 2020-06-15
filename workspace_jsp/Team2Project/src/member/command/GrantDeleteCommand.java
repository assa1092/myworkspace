package member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;
import member.domain.MemberDTO;
import review.dao.ReviewDAO;
import share.Command;
import share.CommandAction;

public class GrantDeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		String id = request.getParameter("id");
		
		
		if(session!=null) {
			MemberDTO dto = (MemberDTO)session.getAttribute("login");
			
			if(dto!=null) {
				MemberDAO dao = new MemberDAO();		
				String property = dto.getProperty();
				ReviewDAO rDao = new ReviewDAO();
				rDao.deleteById(id);
				dao.grantDelete(id, property);
				
				return new CommandAction(true, "membergrantui.do");		
				
			}else {
				return new CommandAction(true, "memberselectui.do");
			}
		}else {
			return new CommandAction(true, "memberselectui.do");
		}
		
		
		
		
	}

}
