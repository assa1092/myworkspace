package member.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;
import member.domain.MemberDTO;
import share.Command;
import share.CommandAction;

public class SelectCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.selectAll();
		
		request.setAttribute("list", list);
		HttpSession session = request.getSession();
		
		
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		boolean manager = false;
		if(dto!=null){
		if(dto.getProperty().equals("admin")){
			manager=true;
			
		}else{
			manager=false;
		}}
		request.setAttribute("manager", manager);
		
		

		return new CommandAction(false, "memberselect.jsp");
	}

}
