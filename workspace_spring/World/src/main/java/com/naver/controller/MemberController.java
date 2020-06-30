package com.naver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.MemberDTO;
import kr.co.service.MemberService;

@Controller
// @RequestMapping을 클래스 단위로도 묶을수 있다.
@RequestMapping("member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) {
		List<MemberDTO> list = memberService.list();
		model.addAttribute("list",list);
		// return 생략되있으면 list.jsp이동.
	}
	
	// post로 보냈기 때문에 post로 받아야한다...
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(MemberDTO dto) {
		// 예전 memberlist.do 로 가야한다...
		memberService.insert(dto);	//
		return "redirect:/member/list";
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.GET)
	public String insert() {
		return "member/insert";
	}

}
