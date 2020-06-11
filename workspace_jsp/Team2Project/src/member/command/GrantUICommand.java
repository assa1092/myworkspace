package member.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import member.dao.MemberDAO;
import member.domain.MemberDTO;
import share.Command;
import share.CommandAction;

public class GrantUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession(false);
		if (session != null) {
			MemberDTO dto = (MemberDTO) session.getAttribute("login");
			if (dto != null) {
				if (dto.getProperty().equals("admin")) {
					MemberDAO dao = new MemberDAO();
					List<MemberDTO> customerList = new ArrayList<MemberDTO>();
					List<MemberDTO> managerList = new ArrayList<MemberDTO>();
					customerList = dao.selectList("customer");
					managerList = dao.selectList("manager");

					request.setAttribute("cus", customerList);
					request.setAttribute("man", managerList);
					
					request.setAttribute("admin", true);

					return new CommandAction(false, "membergrant.jsp");
				} else if (dto.getProperty().equals("manager")) {

					MemberDAO dao = new MemberDAO();
					List<MemberDTO> customerList = new ArrayList<MemberDTO>();
					customerList = dao.selectList("customer");
					request.setAttribute("cus", customerList);

					request.setAttribute("admin", false);

					return new CommandAction(false, "membergrant.jsp");
				} else {
					return new CommandAction(true, "memberselect.do");
				}
			} else {
				return new CommandAction(true, "memberselect.do");
			}
		} else {
			return new CommandAction(true, "memberselect.do");
		}

//		MemberDAO dao = new MemberDAO();
//		List<MemberDTO> customerList = new ArrayList<MemberDTO>();
//		List<MemberDTO> managerList= new ArrayList<MemberDTO>();
//		customerList = dao.selectList("customer");
//		managerList = dao.selectList("manager");
//		
//		request.setAttribute("cus", customerList);
//		request.setAttribute("man", managerList);
//		
//		
//		
//		
//		
//		
//		return new CommandAction(false, "grant.jsp");
//		
//		

	}

}
