package com.naver;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insert
 */

public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	// 서버쪽으로 보낼때 (request) 한글 깨지지 않게
		
		response.setContentType("text/html; charset= utf-8");	// 서버쪽으로 받을때 (response) 한글 깨지지 않게 
		
		String id = request.getParameter("id");	// 서버쪽으로 데이터 보낼때 파라미터 
		String name = request.getParameter("name");
		
		String sAge = request.getParameter("age");
		int age = 0;
		if (sAge != null) {
			 age = Integer.parseInt(sAge);
			 // age = Integer.valueOf(sAge); 같은 결과
		}
		System.out.println(id);
		System.out.println(name);
		System.out.println(age);
		
		// 포워딩... 
		// url-pattern 값이 select 로
		// Dispatcher 방식 : 주소창에 주소가 안바뀌면서 이동 하는 방식
		// RequestDispatcher dis =  request.getRequestDispatcher("select");	
		// dis.forward(request, response);
		
		// Redirect 방식 :  주소창에 주소가 바뀌면서 이동하는 방식
		response.sendRedirect("select");
		
		
	}

}
