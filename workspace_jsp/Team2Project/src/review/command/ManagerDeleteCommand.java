package review.command;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;
import member.domain.MemberDTO;
import review.dao.ReviewDAO;
import review.domain.UploadDTO;
import share.Command;
import share.CommandAction;

public class ManagerDeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sNum = request.getParameter("num");
		int num = -1;
		if(sNum!=null) {
			num=Integer.valueOf(sNum);
		}
		
		HttpSession session = request.getSession();
		if(session!=null) {
			MemberDTO dto = (MemberDTO) session.getAttribute("login");
			if(dto!=null) {
				if(dto.getProperty().equals("admin")||dto.getProperty().equals("manager")) {
					ReviewDAO dao = new ReviewDAO();
				
					
					String uploadPath = this.getClass().getResource("").getPath();
					uploadPath = uploadPath.substring(1, uploadPath.indexOf(".metadata")) + "Team2Project" + File.separator
							+ "WebContent" + File.separator + "upload";
					
					UploadDTO uDto = dao.imgSelect(num);
					
					String fileName = uDto.getFileName();
					
					String filePath = uploadPath +File.separator+ fileName;
					
					File file = new File(filePath);
					
					if(file.exists()) file.delete();
					
					
					
					
					dao.delete(num);
				}
			}
			
			
		}
		
		
		
		
		
		
		
		return new CommandAction(true, "reviewlist.do");
	}

}
