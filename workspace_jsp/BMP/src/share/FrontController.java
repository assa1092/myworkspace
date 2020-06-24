package share;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uri = request.getRequestURI();
		String ctxp= request.getContextPath();
		String sp = uri.substring(ctxp.length());
		
		Command com = null;
		if (sp.equalsIgnoreCase("/memberselect.do")) {
			com = new member.SelectCommand();
		} else if (sp.equalsIgnoreCase("/memberinsertui.do")) {
			com = new member.InsertUICommand();
		} else if (sp.equalsIgnoreCase("/memberinsert.do")) {
			com = new member.InsertCommand();
		} else if (sp.equalsIgnoreCase("/memberloginui.do")) {
			com = new member.LoginUICommand();
		} else if (sp.equalsIgnoreCase("/memberlogin.do")) {
			com = new member.LoginCommand();
		} else if (sp.equalsIgnoreCase("/memberlogout.do")) {
			com = new member.LogoutCommand();
		} else if (sp.equalsIgnoreCase("/memberselectById.do")) {
			com = new member.SelectByIdCommand();
		} else if (sp.equalsIgnoreCase("/memberupdateui.do")) {
			com = new member.UpdateUICommand();
		} else if (sp.equalsIgnoreCase("/memberupdate.do")) {
			com = new member.UpdateCommand();
		} else if (sp.equalsIgnoreCase("/memberdelete.do")) {
			com = new member.DeleteCommand();
		} else if(sp.equalsIgnoreCase("/boardlist.do")) {
			//com = new board.ListCommand();
			com = new board.ListPageCommand();
		} else if(sp.equalsIgnoreCase("/boardinsertui.do")) {
			com = new board.InsertUICommand();
		} else if(sp.equalsIgnoreCase("/boardinsert.do")) {
			com = new board.InsertCommand();
		}  else if(sp.equalsIgnoreCase("/boardread.do")) {
			com = new board.ReadCommand();
		}
		
		
		else {
			System.out.println("제공하지 않는 서비스...");
		}
		
		if (com != null) {
			CommandAction action = com.execute(request, response);
			
			if (action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			} else {
				request.getRequestDispatcher(action.getWhere())
				.forward(request, response);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
