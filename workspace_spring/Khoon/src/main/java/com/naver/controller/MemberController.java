package com.naver.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.MemberDTO;
import kr.co.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
		
	@Inject
	MemberService mService;
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST )
	public String insert(MemberDTO mdto) {
		System.out.println(111);
		System.out.println(mdto);
		mService.insert(mdto);
		return "redirect:/member/list";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET )
	public void insert() {
		
	}

}
