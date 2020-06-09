package kr.co.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.dao.BoardDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.PageTO;

public class ListPageCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Command 클래스에서 하는 일
		// 1. 클라이언트가 보내준 데이터 획득및 가공.(숫자...)
		// 2. DAO 객체 생성 및 해당 메소드 호출
		// 3. 데이터 바인딩(pageContext, request, session, application).
		// 4. 포워딩(dispatcher, redirect).
		
		String scurPage = request.getParameter("curPage");
		int curPage = 1;	
		// 기본으로 1페이지 나오게... 초기값 설정할때는 조심...
		// 초기값을 0으로 주거나 할려면 else문에 curPage = 1 로 해줘야한다.
		if (scurPage != null) {
			curPage = Integer.parseInt(scurPage);
		}
		
		BoardDAO dao = new BoardDAO();
		PageTO to = dao.page(curPage);	// 대부분 페이지 처리하는 DTO 를 따로 만든다...
		
		request.setAttribute("to", to);
		request.setAttribute("list", to.getList());	
		//list.jsp에 <c:forEach items="${list }" var="dto"> 보여주기 위해...
		// 아니면...<c:forEach items="${to.list }" var="dto"> 이렇게 호출할건지는 정한다...
		
		
		return new CommandAction(false, "list.jsp");
	}

}
