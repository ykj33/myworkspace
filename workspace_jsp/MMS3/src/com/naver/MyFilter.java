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
//@WebFilter("/*")
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("MyFilter request");
		request.setCharacterEncoding("utf-8");
		// 값을 넘겨줄 때 이미 한글화를 지원해주어야 한다.
		response.setContentType("text/html;charset = utf-8");
		// 해당코드 위쪽은 request 때 실행
		chain.doFilter(request, response);
		// 해당코드 아래쪽은 response때 실행
		System.out.println("MyFilter response");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
