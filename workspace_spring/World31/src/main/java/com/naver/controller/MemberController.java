package com.naver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;
import kr.co.service.MemberService;


// MVC 핸들러
@Controller
// @RequestMapping을 클래스 단위로도 묶을수 있다.
@RequestMapping("member")

//Model 객체의 key 값이 login이라는 것이 있으면 
//session 에 바인딩 시켜라...
// 반드시 model 객체에 바인딩을 시켜놔야 사용가능 
@SessionAttributes({"login"})	
//Spring에서 제공되는 Session 여러개라 배열로 되어있다..


public class MemberController {
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus status) {
		
		status.setComplete();
		
		return "redirect:/member/list";
	}
	
	@RequestMapping(value = "/loginpost", method = RequestMethod.POST)
	public String loginpost(LoginDTO login, Model model ) {
		
		MemberDTO dto = memberService.loginpost(login);
		
		if (dto != null) {
			model.addAttribute("login",dto);
			
			return "redirect:/member/list";
			
		} else {
			return "redirect:/member/login";
		}

	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login() {
		
	}
	
	// 값을 가지고 오는것을 받을때는 @PathVariable("받을값")
	// PathVariable 어노테이션을 사용하여 
	// 계속 바뀌는 변수를 받아 해당 자료형으로 저장한다.
	@RequestMapping(value="/delete/{id}",method = RequestMethod.GET )
	public String delete(@PathVariable("id") String id) {
		memberService.delete(id);
		return "redirect:/member/list";	
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MemberDTO dto) {
		memberService.update(dto);
		
		return "redirect:/member/list";		
	}
	
	
	// 어떤 값인지 모르기때문에 @PathVariable("id") 받아서 처리... 
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String updateui(@PathVariable("id") String id, Model model) {
		System.out.println(id+ "===================");
		// 데이터를 가져와야하기때문에 updateui
		MemberDTO dto = memberService.updateui(id);
		model.addAttribute("dto",dto);
		
		return "/member/update";
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(String id, Model model) {
		MemberDTO dto = memberService.read(id);
		// 바인딩...
		model.addAttribute("dto", dto);
		
	}
	
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
