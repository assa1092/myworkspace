package member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;
import member.domain.MemberDTO;
import share.Command;
import share.CommandAction;

public class SelectByIdCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO mDTO = dao.selectById(id);
		
		request.setAttribute("mDTO", mDTO);
		
		return new CommandAction(false, "memberselectById.jsp");
	}

}
