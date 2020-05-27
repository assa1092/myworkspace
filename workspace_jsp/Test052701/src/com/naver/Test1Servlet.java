package com.naver;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test1Servlet
 */
@WebServlet("/test1")
public class Test1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
							HttpServletResponse response) 
									throws ServletException, IOException {
		// 데이터 바인딩
		request.setAttribute("url", "http://www.naver.com");
		// 모든 타입을 다 저장할수 있다...문자열 뿐만 아니라
		// request는 
		request.setAttribute("list", new ArrayList<StringBuffer>());
				
		System.out.println("test1 doGet");
		
		RequestDispatcher dis = request.getRequestDispatcher("test2");
		dis.forward(request, response);
		// request.getRequestDispatcher("test2").forward(request, response);
		// 이런식으로 한번에 사용 가능 dis=> request.getRequestDispatcher("test2") 로 이해...
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("test1 doPost");
		
		String driverClassName = "oracle.jdbc.driver.OracleDriver";
		// 보통 key 값과. value 값을 같이 해주기 위해 변수 선언해주었다. 
		request.setAttribute("driverClassName", driverClassName);
		
		request.getRequestDispatcher("test2").forward(request, response);
	}

}
