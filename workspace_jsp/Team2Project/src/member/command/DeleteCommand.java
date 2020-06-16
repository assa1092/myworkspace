package member.command;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

public class DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		MemberDTO dto = null;
		if (session != null) {
			dto = (MemberDTO) session.getAttribute("login");			
			if (dto != null) {
				String id = request.getParameter("id");
			
				if (dto.getId().equals(id)) {
					MemberDAO dao = new MemberDAO();
					ReviewDAO rDao = new ReviewDAO();
					
					
					List<UploadDTO> uDto= rDao.selectListNum(id);
					
					String uploadPath = this.getClass().getResource("").getPath();
					uploadPath = uploadPath.substring(1, uploadPath.indexOf(".metadata")) + "Team2Project" + File.separator
							+ "WebContent" + File.separator + "upload";
					
					
					for(int i = 0; i<uDto.size(); i++) {
						
						String filePath = uploadPath +File.separator+ uDto.get(i).getFileName();
						
						System.out.println(uDto.get(i).getFileName());
						
						File f = new File(filePath);
						
						System.out.println(filePath);
						
						if(f.exists()) f.delete();
					}
					
					
					
					

					dao.delete(id);
					session.invalidate();
					return new CommandAction(true, "reviewlist.do");
				} else {
					return new CommandAction(true, "memberloginui.do");
				}			
			} else {
				return new CommandAction(true, "memberloginui.do");
			}
		} else {
			return new CommandAction(true, "memberloginui.do");
		}
	}

}