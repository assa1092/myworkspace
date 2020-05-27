package com.naver;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertUICommand implements Command {
	// 입력하는 화면으로 이동
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		RequestDispatcher dis = request.getRequestDispatcher("insert.jsp");
//		dis.forward(request, response);
		
		request.getRequestDispatcher("insert.jsp").forward(request, response);
		
	}
}
