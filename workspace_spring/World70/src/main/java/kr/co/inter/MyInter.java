package kr.co.inter;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInter extends HandlerInterceptorAdapter {
	
	// 우클릭 source -> override/implements methods 클릭...preHandle, postHandle 클릭...

	@Override
	public boolean preHandle(HttpServletRequest request, 
							HttpServletResponse response, 
							Object handler)
							throws Exception {
		
		System.out.println("preHandle=======================");
		
		HandlerMethod hmethod = (HandlerMethod) handler;
		Method method = hmethod.getMethod();
		
		System.out.println(hmethod.getBean());		// 컨트롤러의 정보알려준다. kr.co.ca.HomeController@6081b928		
		System.out.println(method);					// 어떤 메소드인지...public void kr.co.ca.HomeController.intertest1()
		
		// 리턴이 true 여야만 controller와 postHandle이 실행된다...
		// 리턴이 false 면 controller에 조차  가지를 않는다...
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("postHandle=======================");
		
		// modelAndView.getModel() -> Map 이랑 같다...map.get("test") key 값으로 값을 가져온다...
		Object test = modelAndView.getModel().get("test");
		modelAndView.getModel().put("show", "show");
		System.out.println(test);
		
	}
	
}
