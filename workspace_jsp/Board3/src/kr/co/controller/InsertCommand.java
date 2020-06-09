package kr.co.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;

public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String writer= request.getParameter("writer");
		String title= request.getParameter("title");
		String content= request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();

		// 답글이 아니라 모든게 0... 
		dao.insert(new BoardDTO(-1, writer, title, content, null, 0, 0, 0, 0));
		
		
		// 한번에 여러개 데이타 넣기...
//			for (int i = 7; i < 110; i++) {
//				dao.insert(new BoardDTO(-1, "writer" + i, "title" + i, "content" + i, null, 0, 0, 0, 0));
//				try {
//					Thread.sleep(50);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		return new CommandAction(true, "list.do");	// list.jsp로 가면 빈 양식으로가는것...
	}

}
