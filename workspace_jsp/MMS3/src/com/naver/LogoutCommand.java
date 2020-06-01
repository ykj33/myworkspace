package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션이 굳이 없으면 만들지 않아도 된다.
		HttpSession session = request.getSession(false);
		if (session != null) {

			LoginDTO login = (LoginDTO) session.getAttribute("login");

			// 세션에 바인딩 된 데이터가 없다.
			if (login != null) {
				session.invalidate();

			}
		}
		// 각 if문마다 else를 넣지 말고 공통적으로 하나의 return값만 주는 것이 코드가 깔끔하다.
		return new CommandAction(true, "select.bo");
	}
}
