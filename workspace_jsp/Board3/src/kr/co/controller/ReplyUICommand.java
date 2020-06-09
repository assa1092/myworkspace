package kr.co.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.domain.CommandAction;

public class ReplyUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Command 클래스에서 하는 일
		// 1. 클라이언트가 보내준 데이터 획득및 가공.(숫자...)
		// 2. DAO 객체 생성 및 해당 메소드 호출
		// 3. 데이터 바인딩(pageContext, request, session, application).
		// 4. 포워딩(dispatcher, redirect).
		
		String num = request.getParameter("num");
		
		// request 에 num을 가지고 가던가??? 아님 ㅜㅕ
//		return new CommandAction(false, "reply.jsp?num="+num);
		// 부모의 num값만 가지고 간다...
		return new CommandAction(false, "reply.jsp?num="+num);
	}

}
