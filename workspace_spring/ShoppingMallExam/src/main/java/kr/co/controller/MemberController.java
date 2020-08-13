package kr.co.controller;


import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import kr.co.domain.MemberDTO;
import kr.co.domain.PageTO;
import kr.co.service.MemberService;


@Controller
@RequestMapping("member")
@SessionAttributes

public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private MemberService mService;
	 

	// 로그인 화면
	@RequestMapping("login.do")
	public String login() {
		return "member/login";
	}
	
	// 로그인
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute MemberDTO to, HttpSession session) {
		boolean result = mService.loginCheck(to, session);
		ModelAndView mav = new ModelAndView();
		if (result == true) {
			
			mav.setViewName("home");
			mav.addObject("msg", "success");
		} else { 
			
			mav.setViewName("member/login");
			mav.addObject("msg", "failure");
		}
		return mav;
	}
	
	// 로그아웃
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session) {
		mService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		mav.addObject("msg", "logout");
		return mav;
	}
	
    // 아이디 중복 체크
	

	
	 // 회원 가입 get
	  
	  @RequestMapping(value = "/insert", method = RequestMethod.GET) public String
	 insert() { 
		  
		  return "member/insert"; }
	 
	
	  // 회원 가입 post
	  
	  @RequestMapping(value = "/insert", method = RequestMethod.POST) public String
	  insert(MemberDTO dto) {
	  
		  mService.insert(dto);
	  
	  return "redirect:/member/list"; }
	



	// 검색기능
	@RequestMapping(value = "/searchlist")
	public String serchlist(Model model, String searchType, String keyword) {
		
		List<MemberDTO> list= mService.searchlist(searchType, keyword);
		model.addAttribute("list", list);
		model.addAttribute("searchType", searchType);
	
		return "member/searchlist";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model, String curPage) {
		
		int page = -1;
		if (curPage!=null) {
			page = Integer.parseInt(curPage);
		} else {
			page = 1;
		}
		
		PageTO<MemberDTO> mto = new PageTO<MemberDTO>(page);
		
		mto = mService.list(mto);
		
		model.addAttribute("mto", mto);
		model.addAttribute("list", mto.getList());
		
	}
	
	
	
	@RequestMapping(value = "/delete/{memberno}" , method = RequestMethod.GET)
	public String delete(@PathVariable("memberno") int memberno) {
		
		mService.delete(memberno);
		
		return "redirect:/member/list";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MemberDTO to) {
		mService.update(to);
	
		return "redirect:/member/read/"+to.getMemberNo();
	}
	
	@RequestMapping(value = "/update/{memberno}", method = RequestMethod.GET)
	public String update(@PathVariable("memberno") int memberno, Model model) {
		MemberDTO to = mService.updateUI(memberno);
		model.addAttribute("to", to);
		return "/member/update";
	}
	
	
	@RequestMapping(value = "/read/{memberno}", method = RequestMethod.GET)
	public String read(@PathVariable("memberno") int memberno, Model model) {
		MemberDTO to = mService.read(memberno);
		 model.addAttribute("to", to);
		 return "/member/read";
	}
}

