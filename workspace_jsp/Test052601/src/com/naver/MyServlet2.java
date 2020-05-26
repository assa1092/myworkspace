package com.naver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet2
 */

public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
							HttpServletResponse response) 
									throws ServletException, IOException {
		
		// 서버로 가기전에 한글이 깨져있기 때문에 request로 설정
		// 이 방법은 전체 프로젝트에 적용됨...
		// Servers 프로젝트-> Tomcat v70 Server at localhost-config
		// -> server.xml -> 65번째 줄에...URIEncoding ="utf-8" 추가...
		//  <Connector URIEncoding ="utf-8" connectionTimeout="20000" port="8089" protocol="HTTP/1.1" redirectPort="8443"/>
		
		// String으로 하는 방법도 있음...하나의 프로젝트만 해당하는 방법
		
		
		// 서버에서 보낼때 한글 깨지지 않게끔...response로 설정
		response.setContentType("text/html;charset = utf-8");
		
		// id의 값(value)을 가져와서 id변수에 넣는다.
		String id = request.getParameter("name");	
		
		String sAge = request.getParameter("age");
		int age = 0;
		
		// 값이 없는 상태에서 숫자로 변경하려고해서 에러가난다
		if (sAge != null) {	
			age = Integer.parseInt(sAge);
		}
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print(id);
		out.print("<br>");
		out.print(age);
		out.print("</body>");
		out.print("</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
							HttpServletResponse response) 
									throws ServletException, IOException {
		// 서버로 가기전에 한글이 깨져있기 때문에 request로 설정
		request.setCharacterEncoding("utf-8");
		
		// 서버에서 보낼때 한글 깨지지 않게끔... response로 설정
		response.setContentType("text/html;charset = utf-8");
		
		// 서버로 부터 값을 받아오는것.
		String id = request.getParameter("id");
		System.out.println(id);
		String pw = request.getParameter("pw");
		
		// 서보로 부터 받은 값을 화면에 출력하기위한
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print(id);
		out.print("<br>");
		out.print(pw);
		out.print("</body>");
		out.print("</html>");
		
		
	}

}
