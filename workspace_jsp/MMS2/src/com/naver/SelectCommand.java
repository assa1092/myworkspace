package com.naver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;

public class SelectCommand implements Command{
	// 조회하는 기능...
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = new ArrayList<MemberDTO>(); 
		list = dao.selectAll();
		// 클라이언트에게 보여주기위해...데이터 바인딩
		request.setAttribute("list", list);
		// 리다이렉트로 보내면 데이터가 없어진다...
		request.getRequestDispatcher("select.jsp").forward(request, response);
		
		
		
	}
}
