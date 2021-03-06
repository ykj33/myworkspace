package com.naver;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
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
		// /~~~~ 하는 식으로 데이터 얻어내기
		String uri = request.getRequestURI();
		String ctxp = request.getContextPath();
		String sp = uri.substring(ctxp.length());

		// url에 따라 다른 곳으로 접근 할 수 있도록 한다.
		Command com = null;
		if (sp.equalsIgnoreCase("/insertui.do")) {
			com = new InsertUICommand();
		} else if (sp.equalsIgnoreCase("/insert.do")) {
			com = new InsertCommand();
		} else if (sp.equalsIgnoreCase("/select.do")) {
			com = new SelectCommand();
		} else if (sp.equalsIgnoreCase("/selectById.do")) {
			com = new SelectByIdCommand();
		} else if (sp.equalsIgnoreCase("/updateui.do")) {
			com = new UpdateUICommand();
		} else if (sp.equalsIgnoreCase("/update.do")) {
			com = new UpdateCommand();
		} else if (sp.equalsIgnoreCase("/delete.do")) {
			com = new DeleteCommand();
		} else if (sp.equalsIgnoreCase("/loginui.do")) {
			com = new LoginUICommand();
		} else if (sp.equalsIgnoreCase("/login.do")) {
			com = new LoginCommand();
		} else if (sp.equalsIgnoreCase("/logout.do")) {
			com = new LogoutCommand();
		}

		// 정의되지 않은 접근 시 아예 실행되지 않도록.
		// 컨트롤러가 이제 포워딩을 관리한다.
		if (com != null) {
			CommandAction action = com.execute(request, response);

			// boolean은 get이 아니라 is
			if (action.isRedirect()) {
				// isRedirect() 값이 true라면
				response.sendRedirect(action.getWhere());
			} else {
				// isRedirect() 값이 false라면
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
			}
		}

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
