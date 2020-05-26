package com.naver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 가장 최상단에 존재해야 한다.
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("hello world");
		out.print("</body>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("hello world");
		out.print("</body>");
		out.print("</html>");
	}

}
