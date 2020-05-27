package com.naver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test3
 */
@WebServlet("/test3")
public class Test3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test3() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application = getServletContext();
		application.setAttribute("hello", "hello");

		// List도 저장이 가능하다.
		List<StringBuffer> list = new ArrayList<StringBuffer>();
		list.add(new StringBuffer("good"));
		list.add(new StringBuffer("morning"));
		application.setAttribute("list", list);

		// 실제로 활용되는 코드
		// 맨 처음 사람이 방문하면 count는 null이므로 icount를 1로 초기화를 시켜주어 application에 저장한다.
		Integer icount = (Integer) application.getAttribute("count");
		if (icount == null) {
			icount = 1;
			application.setAttribute("count", icount);
		} else {
			// 만약 최초방문자여서 count값이 null이 아니라면 방문자 수를 늘려준다.
			application.setAttribute("count", icount + 1);
		}

		request.getRequestDispatcher("NewFile.jsp").forward(request, response);
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
