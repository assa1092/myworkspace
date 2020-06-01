package com.naver;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MyFilter
 */
// @WebFilter("/*") // 확장자, 디렉토리 모든것 다...적용..
public class MyFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, 
							ServletResponse response, 
							FilterChain chain) 
									throws IOException, ServletException {
	
		System.out.println("My Filter request");
		// chain.doFilter(request, response); 를 기준으로 위쪽은 
		// request 때 실행되는 코드
		
		// request 때 한글 지원을 다 해주어야 response 때도 적용가능...
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		chain.doFilter(request, response);
		
		// chain.doFilter(request, response); 를 기준으로 밑에쪽은 
		// response 때 실행되는 코드
		System.out.println("My Filter response");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
