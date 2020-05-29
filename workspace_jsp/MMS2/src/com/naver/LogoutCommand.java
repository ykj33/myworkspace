package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class LogoutCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 파라미터로 false를 넣으면 session이 없으면 없는대로 간다.
		HttpSession session = request.getSession(false);
		if (session != null) {
			// 1. 세션시간 줄이기
//			session.setMaxInactiveInterval(1);

//			2. 세션 없애기
			session.invalidate();

//			3. 바인딩 된 데이터 없애기
//			session.removeAttribute("login");
		}
//		response.sendRedirect("select.do");
		return new CommandAction(true, "select.do");
	}

}
