package kr.co.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;

public class ReplyCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Command 클래스에서 하는 일
		// 1. 클라이언트가 보내준 데이터 획득및 가공.(숫자...)
		// 2. DAO 객체 생성 및 해당 메소드 호출
		// 3. 데이터 바인딩(pageContext, request, session, application).
		// 4. 포워딩(dispatcher, redirect).
		String sNum = request.getParameter("num");
		// 그냥 num이 아니라 원글의 num...
		int orgnum = -1;
		if (sNum != null) {
			orgnum = Integer.parseInt(sNum);
		}
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto =new BoardDTO(-1, writer, title, content, null, 0, -1, -1, -1);
				
		// 부모의 num값만 있으면 repRoot 를 가져올수있다...
		dao.reply(orgnum, dto);
		
		
		return new CommandAction(true, "list.do");
	}

}
