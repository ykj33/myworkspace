package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age = 0;
		if (sAge != null) {
			age = Integer.parseInt(sAge);
		}
		String pw = request.getParameter("pw");
		MemberDAO dao = new MemberDAO();

		dao.update(new MemberDTO(id, name, age, pw));

		// 해당 id가 선택된 곳으로 가야하므로
		return new CommandAction(true, "selectById.bo?id=" + id);

	}

}
