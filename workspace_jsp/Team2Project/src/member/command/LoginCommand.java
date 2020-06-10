package member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import member.dao.MemberDAO;
import member.domain.MemberDTO;
import share.Command;
import share.CommandAction;

public class LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.login(id, pw);
		System.out.println("로그인 dao 완료");

		if (dto.getPw() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", dto);
			return new CommandAction(false, "reviewlist.do");
		} else {
			System.out.println("로그인실패");
			return new CommandAction(true, "memberloginfalse.jsp");
		}
		// TODO Auto-generated method stub

	}

}
