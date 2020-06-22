package member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import share.Command;
import share.CommandAction;

public class GrantUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		
		// 세션 객체를 만들때는 request를 이용한다.
//		request.getSession();	  // 없으면 만들어서라도 넘겨달라는 의미
//		request.getSession(true); // 없으면 만들어서라도 넘겨달라는 의미
//		request.getSession(false);// 없으면 놔둬...의미
		
		HttpSession session = request.getSession(false);
		if (session !=null) {
			MemberDTO dto = (MemberDTO) session.getAttribute("login");
			if (dto != null) {
				if (dto.getProperty().equals("admin")) {
					MemberDAO dao = new MemberDAO();
					List<MemberDTO> customerList= dao.selectList("customer");
					List<MemberDTO> managerList = dao.selectList("manager");
					
					request.setAttribute("customerList", customerList);
					request.setAttribute("managerList", managerList);
					request.setAttribute("admin", true);
					
					return new CommandAction(false, "membergrant.jsp");
				} else if(dto.getProperty().equals("manager")) {
					List<MemberDTO> customerList = new ArrayList<MemberDTO>();
					MemberDAO dao = new MemberDAO();
					customerList = dao.selectList("customer");
										
					request.setAttribute("customerList", customerList);
					request.setAttribute("admin", false);
					
					return new CommandAction(true, "membergrant.jsp");
				}
			} else {
				return new CommandAction(true, "memberselect.do");
			}
			
		} else {
			return new CommandAction(true, "memberselect.do");
		}
		return new CommandAction(true, "memberselect.do");
		
	}

}
