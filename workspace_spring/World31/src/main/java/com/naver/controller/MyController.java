package com.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.utils.Utils;

// @Controller를 작성해주어여 controller 될 준비작업...
// spring 환경설정파일로(servlet-controller.xml) 가서 
// <context:component-scan base-package="com.naver.controller" />
// 작성 해주어야 진짜 Controller 역활가능...

@Controller
public class MyController {
	// MVC 핸들러..작업.
	// 배열로 값을 주어도 된다...
	// @RequestMapping(value = {"hello", "HELLO"})
	@RequestMapping(value="test", method = RequestMethod.GET)
	// 예전의 request처럼 안하고...그냥 넘겨받을 변수만 정의 해주어도된다.
	public void test(String name) {
		name = Utils.toKor(name);
		
		System.out.println(name);
		
	}
	
	
	@RequestMapping(value = "good", method = RequestMethod.GET)
	// 보통은 GET 으로 보낸다...POST로 하면 바인딩해서 보내야하기때문에...
	// GET 으로 보내면서 request처럼 model 을 이용하면 그대로 쓸수있다...
	public void good(Model model) {
		
		model.addAttribute("test", "test입니다.");
		// good.jsp 로 넘어간다.
	}
	
	@RequestMapping(value = "world", method = RequestMethod.GET)
	public void world() {
		// return 값이 없으면 value 값이 view값 jsp 파일...
		// world.jsp
	}
	
	
	@RequestMapping(value ="hello", method = RequestMethod.GET)
	public String hello() {
		return "hello";		// return 값은 view 페이지의 이름...jsp파일 이름...
	}
	
}
