package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dto.MemberDTO;

public class InsertCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, 
							HttpServletResponse response) throws ServletException, IOException {
		//클라이언트로 보내는 ... 값 받아오기
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age = 0;
		if (sAge != null) {
			age = Integer.valueOf(sAge);
		}
		
		MemberDTO dto = new MemberDTO(id, name, age);
		
		MemberDAO dao = new MemberDAO();
		dao.insert(dto);
		
		// 반환형이 void 였기 때문에 지금은 여기서 포워딩..해준다.
		// 나중에는 따로 해준다.
		response.sendRedirect("select");		// 보통 select 말고 list 로 많이씀...
		
	}
}
