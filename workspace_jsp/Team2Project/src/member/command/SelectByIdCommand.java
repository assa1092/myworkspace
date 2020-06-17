package member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;
import member.domain.MemberDTO;
import share.Command;
import share.CommandAction;

public class SelectByIdCommand implements Command {

   @Override
   public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      String id = request.getParameter("id");
      
      HttpSession session = request.getSession();
      MemberDTO sessionDTO = null;
      if (session != null) {
         sessionDTO = (MemberDTO) session.getAttribute("login");
         if (sessionDTO != null) {

               MemberDAO dao = new MemberDAO();
               MemberDTO mDTO = dao.selectById(id);
               if(mDTO.getProperty().equals("admin")) {
                  request.setAttribute("admin", true);
               }else if(mDTO.getProperty().equals("manager")) {
                  request.setAttribute("manager", true);
               } else {
                  request.setAttribute("customer", true);
               }
               
               request.setAttribute("mDTO", mDTO);
               
               return new CommandAction(false, "memberselectById.jsp");
               //            
            } else {
               return new CommandAction(true, "memberloginui.do");
            }
         } else {
            return new CommandAction(true, "memberloginui.do");
         }

         
      
   }

}