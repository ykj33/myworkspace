package com.naver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet2
 */
@WebServlet("/MyServlet2")
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		// 클라이언트에서 서버에 요청, request이고 id값을 받아와서 id라는 변수에 넣어준다.
		String name = request.getParameter("name");
		// 모든 데이터는 String으로 받기 때문에 다른 데이터 타입으로 변환은 Wrapper클래스를 사용하면 된다.
		String sAge = request.getParameter("age");
		int age = 0;
		// null값에 따른 에러 방지위해 if문으로 묶어줌
		if (sAge != null) {
			age = Integer.parseInt(sAge);
		}

		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print(name);
		out.print(age);
		out.print("</body>");
		out.print("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 클라이언트에서 데이터를 보낼 때 한글이 깨지지 않게 하기
		request.setCharacterEncoding("utf-8");
		// 서버에 데이터 보내기
		response.setContentType("text/html;charset = utf-8");
		String id = request.getParameter("id");
		System.out.println(id);
		String pw = request.getParameter("pw");

		// 서버가 받은 데이터를 클라이언트에 출력하기
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("id : " + id);
		out.print("<br>");
		out.print("pw : " + pw);
		out.print("</body>");
		out.print("</html>");

	}

}
