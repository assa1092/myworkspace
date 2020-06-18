package member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import share.Command;
import share.CommandAction;

public class ListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.selectAll();
		
		request.setAttribute("list", list);
		
		return new CommandAction(false, "memberlist.jsp");
	}

}
