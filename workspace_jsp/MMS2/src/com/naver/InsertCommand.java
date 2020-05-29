package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;


// Command 클래스에서 하는 일
// 1. 클라이언트가 보내준 데이터 획득및 가공.(숫자...)
// 2. DAO 객체 생성 및 해당 메소드 호출
// 3. 데이터 바인딩.
// 4. 포워딩.

public class InsertCommand implements Command{
	// 입력된 값을 DB에 저장하는 기능.
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트가 보내준 데이터 획득및 가공.(숫자...)
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		
		int age = 0;
		if (sAge !=null) {
			age = Integer.parseInt(sAge);
		}
		
		// 2. DAO 객체 생성 및 해당 메소드 호출
		MemberDTO dto = new MemberDTO(id, name, age);
		MemberDAO dao = new MemberDAO();
		dao.insert(dto);
		
		// 4. 포워딩(dispatcher, redirect).
//		response.sendRedirect("select.do");	// 서블릿을 거칠려면 .do로 넘어가야한다.
		return new CommandAction(true, "select.do");
		
		
	}
}
