package com.naver;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test2
 */

public class Test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// test1에 선언하고 test2에서 호출해서 null로 나옴...
		// 초기화 파라미터로 선언했기때문에 다른 곳에서는 호출 불가...
		
		String dcn = getInitParameter("driverClassName");
		String url = getInitParameter("url");
		
		System.out.println(dcn);
		System.out.println(url);
		
		
		// context-param 로 선언했기 때문에 다른 서블릿에서도 쓸수있다.
		// 쓰기전에 객체를 생성해야한다.
		
		ServletContext application  = getServletContext();
		
		String un = application.getInitParameter("username");
		String pw = application.getInitParameter("password");
		
		
		System.out.println(un);
		System.out.println(pw);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
