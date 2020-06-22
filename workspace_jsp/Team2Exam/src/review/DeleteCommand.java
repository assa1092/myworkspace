package review;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberDTO;
import share.Command;
import share.CommandAction;

public class DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session !=null) {
			MemberDTO login = (MemberDTO) session.getAttribute("login");
			if (login !=null) {
				String id = request.getParameter("id");
				
				if((login.getId().equals(id)) 
					|| (login.getProperty().equals("admin")) 
					|| (login.getProperty().equals("manager"))) {
					
					String sNum = request.getParameter("num");
					int num = -1;
					if (sNum != null) {
						num = Integer.parseInt(sNum);
					}
					ReviewDAO dao = new ReviewDAO();
					
					String uploadPath = this.getClass().getResource("").getPath();
					uploadPath = uploadPath.substring(1, uploadPath.indexOf(".metadata")) 
							+ "Team2Exam" + File.separator + "WebContent"  + File.separator + "upload";
					
					uploadDTO dto = dao.imgSelect(num);
					
					String fileName = dto.getFileName();
					
					String filePath = uploadPath + File.separator + fileName;
					
					File file = new File(filePath);
					
					if (file.exists()) {
						file.delete();
					}
					dao.delete(num);
					
					return new CommandAction(true, "reviewlist.do");
				}
			} else {
				return new CommandAction(true, "notdelete.jsp");
			}
			
		} else {
			return new CommandAction(true, "memberlogin.do");
		}
	
			return new CommandAction(true, "memberlogin.do");
	}

}
