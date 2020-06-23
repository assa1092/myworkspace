package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import share.Command;
import share.CommandAction;

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		
		MemberDTO dto = new MemberDTO(id, name, pw, null);
		MemberDAO dao = new MemberDAO();
		dao.update(dto);
		
		return new CommandAction(true, "selectById.do?id="+id);
	}

}
