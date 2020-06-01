package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			LoginDTO login = (LoginDTO) session.getAttribute("login");
			if (login != null) {
				String id = request.getParameter("id");

				// 현재 로그인 되어있는 아이디와 delete.bo?id=의 아이디가 같은가?
				if (login.getId().equals(id)) {
					MemberDAO dao = new MemberDAO();
					dao.delete(id);
					session.invalidate();
					return new CommandAction(true, "select.bo");
				} else {
					return new CommandAction(true, "login.bo");
				}

			} else {
				return new CommandAction(true, "login.bo");
			}

		} else {
			return new CommandAction(true, "login.bo");
		}

	}

}
