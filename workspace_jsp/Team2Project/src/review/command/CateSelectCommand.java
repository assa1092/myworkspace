package review.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.dao.ReviewDAO;
import review.domain.PageTO;
import review.domain.ReviewDTO;
import share.Command;
import share.CommandAction;

public class CateSelectCommand implements Command{

   @Override
   public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
   
      
   String category = request.getParameter("category");
   String scurPage = request.getParameter("curPage");
   int curPage = 1;
   if (scurPage != null) {
      curPage = Integer.parseInt(scurPage);
   }
   System.out.println(curPage);
   ReviewDAO dao = new ReviewDAO();
   PageTO to = dao.catepage(curPage, category);
   // List<ReviewDTO> list = dao.list();
   request.setAttribute("list", to.getList());
   request.setAttribute("to", to);
   request.setAttribute("category", category);
   // TODO Auto-generated method stub
   return new CommandAction(false, "reviewcategory.jsp");
}

}