package com.naver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    // 클라이언트는 서버에 get과 post 중 하나로 요청을함.
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		


		// 문자열 값을 받아오는것 
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("Hello");
		out.print("</body>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// doPost는 응답받아서 가져오는 것이라 바로 안나온다...
		// 그래서 form tag를 써서 값을 가져와야한다.
		// NewFile1.jsp에 작성이 되어있다...
		// <form action="test" method= "post">
		// <input type = "submit" value = "click">
		// </form>
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name"); //return type : String

		response.setContentType("text/html; charset=UTF-8");
						
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print(name + "Good Morning");
		out.print("</body>");
		out.print("</html>");
	}

}
