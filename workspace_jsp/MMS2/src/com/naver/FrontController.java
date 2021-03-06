package com.naver;

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
		// 클라이언트가 서버로 보낼때 한글이 깨지지 않게하기 위해
		request.setCharacterEncoding("utf-8");
		// 서버에서 클라이언트로 보낼때 한글이 깨지지 않게하기 위해
		response.setContentType("text/html;charset = utf-8");
		
		// 서블릿 패스 가져오는 법
		String uri = request.getRequestURI();	//http://localhost:8089/MMS2/login.jsp
		String ctxp = request.getContextPath();	//http://localhost:8089/MMS2
		String sp = uri.substring(ctxp.length());//앞쪽에껏 자르고 나면 서블릿 패스 *.do  
		
		Command com = null;
		if(sp.equalsIgnoreCase("/insertui.do")) {
			com = new InsertUICommand();
		} else if(sp.equalsIgnoreCase("/insert.do")) {
			com = new InsertCommand();
		} else if(sp.equalsIgnoreCase("/select.do")) {
			com = new SelectCommand();
		} else if(sp.equalsIgnoreCase("/selectById.do")) {
			com = new SelectByIdCommand();
		} else if(sp.equalsIgnoreCase("/updateui.do")) {
			com = new UpdateUICommand();
		} else if(sp.equalsIgnoreCase("/update.do")) {
			com = new UpdateCommand();
		} else if(sp.equalsIgnoreCase("/delete.do")) {
			com = new DeleteCommand();
		} else if(sp.equalsIgnoreCase("/loginui.do")) {
			com = new LoginUICommand();
		} else if(sp.equalsIgnoreCase("/login.do")) {
			com = new LoginCommand();
		} else if(sp.equalsIgnoreCase("/logout.do")) {
			com = new LogoutCommand();
		}
		
		// 이렇게 CommandAction으로 처리해서.
		// 컨트롤러가 포워딩을 관리한다.
		if(com != null) {	
			// 정해놓은것 외에 다른 것이 들어오지 않으면...실행..
			CommandAction action = com.execute(request, response);
			
			if(action.isRedirect()) {
				
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
