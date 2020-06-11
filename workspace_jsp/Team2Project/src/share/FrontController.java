package share;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.command.GrantCommand;
import member.command.GrantUICommand;
import member.command.LoginCommand;
import member.command.LoginUICommand;
import member.command.LogoutCommand;
import member.command.SelectByIdCommand;
import member.command.SelectCommand;
import review.command.DeleteCommand;
import review.command.InsertCommand;
import review.command.InsertUICommand;
import review.command.ListPageCommand;
import review.command.ReadCommand;
import review.command.UpdateCommand;
import review.command.UpdateUICommand;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String sp = uri.substring(ctx.length());
		Command com = null;

		if (sp.equalsIgnoreCase("/reviewlist.do")) {
			com = new review.command.ListPageCommand();
		} else if (sp.equalsIgnoreCase("/reviewread.do")) {
			com = new review.command.ReadCommand();
		} else if (sp.equalsIgnoreCase("/reviewinsertui.do")) {
			com = new review.command.InsertUICommand();
		} else if (sp.equalsIgnoreCase("/reviewinsert.do")) {
			com = new review.command.InsertCommand();
		} else if (sp.equalsIgnoreCase("/reviewdelete.do")) {
			com = new review.command.DeleteCommand();
		} else if (sp.equalsIgnoreCase("/reviewupdateui.do")) {
			com = new review.command.UpdateUICommand();
		} else if (sp.equalsIgnoreCase("/reviewupdate.do")) {
			com = new review.command.UpdateCommand();
		} else if (sp.equalsIgnoreCase("/memberloginui.do")) {
			com = new member.command.LoginUICommand();
		} else if (sp.equalsIgnoreCase("/memberlogin.do")) {
			com = new member.command.LoginCommand();
		} else if (sp.equalsIgnoreCase("/memberselect.do")) {
			com = new member.command.SelectCommand();
		} else if (sp.equalsIgnoreCase("/memberlogout.do")) {
			com = new member.command.LogoutCommand();
		} else if (sp.equalsIgnoreCase("/memberinsertui.do")) {
			com = new member.command.InsertUICommand();
		} else if (sp.equalsIgnoreCase("/memberinsert.do")) {
			com = new member.command.InsertCommand();
		} else if (sp.equalsIgnoreCase("/memberinsertui.do")) {
			com = new member.command.InsertUICommand();
		} else if (sp.equalsIgnoreCase("/memberselectById.do")) {
			com = new member.command.SelectByIdCommand();
		} else if (sp.equalsIgnoreCase("/memberupdateui.do")) {
			com = new member.command.UpdateUICommand();
		} else if (sp.equalsIgnoreCase("/memberupdate.do")) {
			com = new member.command.UpdateCommand();
		} else if (sp.equalsIgnoreCase("/memberdelete.do")) {
			com = new member.command.DeleteCommand();
		} else if (sp.equalsIgnoreCase("/membergrantui.do")) {
			com = new member.command.GrantUICommand();
		} else if (sp.equalsIgnoreCase("/membergrant.do")) {
			com = new member.command.GrantCommand();
		} else if (sp.equalsIgnoreCase("/membergrantdelete.do")) {
			com = new member.command.GrantDeleteCommand();
		} else if (sp.equalsIgnoreCase("/reviewsearch.do")) {
			com = new review.command.SearchCommand();
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
