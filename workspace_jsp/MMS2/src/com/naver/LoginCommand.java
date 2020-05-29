package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kr.co.dao.MemberDAO;
import kr.co.domain.LoginDTO;

public class LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		MemberDAO dao = new MemberDAO();
		boolean login = dao.login(new LoginDTO(id, pw));

		if (login) {
			// session이 없으면 만들어서라도 줘라.
//			request.getSession(true);
			// 로그인 되었을 때만 session객체를 만들어서 사용할 것
			HttpSession session = request.getSession();
			// 세션이 유지되는 시간 여기서는 초
			session.setMaxInactiveInterval(60);
			// 로그인이 성공하면 세션에 데이터를 바인딩해서 select.do로 넘어간다.
			// pw는 같을 수 있어도 id는 primary key이므로 id만 검증하면 된다.
			session.setAttribute("login", new LoginDTO(id, null));
			// session은 스코프가 시간과 브라우저만 같으면 유지되므로 redirect 가능
//			response.sendRedirect("select.do");
			return new CommandAction(true, "select.do");
		} else {
//			response.sendRedirect("loginui.do");
			return new CommandAction(true, "loginui.do");
		}

		// 없으면 주지 않아도 된다.
//		request.getSession(false);

	}

}
