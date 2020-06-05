package com.naver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IDChecker
 */
@WebServlet("/idcheck")
public class IDChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IDChecker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
							HttpServletResponse response) 
									throws ServletException, IOException {
		// id 중복검사 해달라고 보내줌...받아서 사용
		String id = request.getParameter("id");
		System.out.println("별도의 Command 클래스를 지정하여 실행");
		System.out.println("Command클래스 네에서 DAO 객체 생성 및 해당 메서드 호출 -> 데이터 반환");
		
		boolean idCheck = false;	// 반환형에 따라 맞게 자료형 설정.
		
		if (idCheck) {
			// response.getWriter().print() = > out.print()
			response.getWriter().print("사용 가능한 아이디 입니다.");
		} else {
			response.getWriter().print("사용 불가능한 아이디 입니다.");
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
