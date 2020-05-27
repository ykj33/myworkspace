package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;

public class InsertCommand implements Command {
	// 실제로 데이터를 입력받아 저장함
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age = 0;
		if (sAge != null) {
			age = Integer.parseInt(sAge);
		}
		MemberDAO dao = new MemberDAO();
		dao.insert(new MemberDTO(id, name, age));

		// DB를 다녀와야 하므로 servlet으로 가야한다.
		response.sendRedirect("select.do");
	}
}
