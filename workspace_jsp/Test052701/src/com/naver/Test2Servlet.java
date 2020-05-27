package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test2Servlet
 */
@WebServlet("/test2")
public class Test2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("test2 doGet");
		
		// request.getAttribut가 반환형이 object라 형 변환 시켜준다..
		// 데이터 바인딩...
		// Test1Servlet에서(test1) 에서 데이터를 보낼 때 url/ list 형식으로 보냈다...
		String url = (String) request.getAttribute("url");
		List<StringBuffer> list = (List<StringBuffer>) request.getAttribute("list");
		
		System.out.println(url);
		System.out.println(list);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String driverClassName = (String) request.getAttribute("driverClassName");
		System.out.println(driverClassName);
		
		System.out.println("test2 doPost");
	}

}
