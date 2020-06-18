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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String uri = request.getRequestURI();
		String ctxp = request.getContextPath();
		String sp = uri.substring(ctxp.length());
		
		Command com = null;
		
		if (sp.equalsIgnoreCase("/reviewlist.do")) {
			com = new review.ListPageCommand();
		} else if(sp.equalsIgnoreCase("/reviewread.do")) {
			com = new review.ReadCommand();
		} else if(sp.equalsIgnoreCase("/reviewupdateui.do")) {
			com = new review.UpdateUICommand();
		} else if(sp.equalsIgnoreCase("/reviewupdate.do")) {
			com = new review.UpdateCommand();
		} else if (sp.equalsIgnoreCase("/reviewinsertui.do")) {
			com = new review.InsertUICommand();
		} else if (sp.equalsIgnoreCase("/reviewinsert.do")) {
			com = new review.InsertCommand();
		} else if (sp.equalsIgnoreCase("/memberinsertui.do")) {
			com = new member.InsertUICommand();
		} else if (sp.equalsIgnoreCase("/memberinsert.do")) {
			com = new member.InsertCommand();
		} else if (sp.equalsIgnoreCase("/memberlist.do")) {
			com = new member.ListCommand();
		} else if (sp.equalsIgnoreCase("/memberloginui.do")) {
			com = new member.LoginUICommand();
		} else if (sp.equalsIgnoreCase("/memberlogin.do")) {
			com = new member.LoginCommand();
		}else if (sp.equalsIgnoreCase("/memberlogout.do")) {
			com = new member.LogoutCommand();
		}
		
		else {
			System.out.println("제공하지 않는 서비스 입니다.");
		}
		
		if (com != null) {
			CommandAction action = com.execute(request, response);
			if (action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			} else {
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
				
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
