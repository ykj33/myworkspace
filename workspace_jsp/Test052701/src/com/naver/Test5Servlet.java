package com.naver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test5Servlet
 */
@WebServlet("*.do")
public class Test5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test5Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");

		// *로 처리된 클라이언트의 요구사항을 알아낼 수 있다.
		// 아직 사용되지 않는 코드
//		String sp = request.getServletPath();
//		System.out.println(sp);

		// 현재 사용하는 코드
		// 전체 path받아오기
		String uri = request.getRequestURI();
		// Context만 받아오기
		String ctxp = request.getContextPath();
		// 서블릿 path만 잘라내기
		String sp = uri.substring(ctxp.length());
		System.out.println(uri);
		System.out.println(ctxp);
		System.out.println(sp);
		// if문으로 대소문자를 무시하고 조건문 비교, /를 붙여야 함
		if (sp.equalsIgnoreCase("/insert.do")) {
			System.out.println("입력입니다.");
		} else if (sp.equalsIgnoreCase("/select.do")) {
			System.out.println("조회입니다.");
		} else if (sp.equalsIgnoreCase("/update.do")) {
			System.out.println("수정입니다.");
		}

		System.out.println(".do로 끝나는 요청은 모두 이 서블릿으로 들어온다.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
