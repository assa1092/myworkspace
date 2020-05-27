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
		String uri = request.getRequestURI();
		String ctxp = request.getContextPath();
		String sp = uri.substring(ctxp.length());	// 앞쪽에껏 자르고 나면....서블릿 패스
		
		Command com = null;
		if(sp.equalsIgnoreCase("/insertui.do")) {
			com = new InsertCommand();
		}else if(sp.equalsIgnoreCase("/insert.do")) {
			com = new InsertCommand();
		} else if(sp.equalsIgnoreCase("/select.do")) {
			com = new SelectCommand();
		}
		
		if(com != null) {	
			// 정해놓은것 외에 다른 것이 들어오지 않으면...실행..
			com.execute(request, response);
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
