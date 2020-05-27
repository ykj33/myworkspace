package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.LSTORE;

/**
 * Servlet implementation class Test2Servlet
 */
@WebServlet("/test2")
public class Test2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test2Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("test2 doGet");

		// 반환형이 Object이므로 강제 형변환이 필요
		String url = (String) request.getAttribute("url");
		List<StringBuffer> list = (List<StringBuffer>) request.getAttribute("list");

		System.out.println(url);
		System.out.println(list);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String driverClassName = (String) request.getAttribute("driverClassName");
		System.out.println(driverClassName);
		System.out.println("test2 doPost");
	}

}
