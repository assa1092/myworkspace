package kr.co.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;

public class UpdateUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Command 클래스에서 하는 일
		// 1. 클라이언트가 보내준 데이터 획득및 가공.(숫자...)
		// 2. DAO 객체 생성 및 해당 메소드 호출
		// 3. 데이터 바인딩(pageContext, request, session, application).
		// 4. 포워딩(dispatcher, redirect).
		String sNum = request.getParameter("num");
		int num = -1;
		if (sNum != null) {
			num = Integer.parseInt(sNum);
		}
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.updateUI(num);
		
		request.setAttribute("dto", dto);
		
		return new CommandAction(false, "update.jsp");
	}

}
