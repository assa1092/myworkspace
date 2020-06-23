package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import share.Command;
import share.CommandAction;

public class SelectByIdCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectById(id);
		
		// 3. 데이터 바인딩(pageContext, request, session, application).
		request.setAttribute("dto", dto);
		
		// 데이터 값이 있으면 무조건 dispatcher...
		return new CommandAction(false, "selectById.jsp");
	}

}
