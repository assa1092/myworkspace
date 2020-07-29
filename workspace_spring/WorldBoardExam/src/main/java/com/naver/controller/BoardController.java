package com.naver.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	@Inject
	private BoardService bService;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model, String curPage) {
		int page = -1;
		if (curPage == null) {
			page = 1;
		} else {
			page = Integer.parseInt(curPage);
		}
		
		PageTO<BoardVO> to = new PageTO<BoardVO>(page);
		to = bService.list(to);
		
		model.addAttribute("to",to);
		model.addAttribute("list", to.getList());
//		List<BoardVO> list = bService.list();
//		model.addAttribute("list", list);
		
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public String insert(BoardVO vo) {
		
		bService.insert(vo);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert() {
		
	}
	

}
