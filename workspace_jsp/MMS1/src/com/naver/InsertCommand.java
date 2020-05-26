package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dto.MemberDTO;

public class InsertCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 값을 받아옴
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age = 0;
		if (sAge != null) {
			age = Integer.parseInt(sAge);
		}

		// dao 객체를 만들어 저장
		MemberDAO dao = new MemberDAO();
		dao.insert(new MemberDTO(id, name, age));

//		execute의 리턴값이 void이므로 포워딩을 직접해주어야한다.
//		양식에 데이터를 먼저 뿌려주고 양식을 보아야 하므로 DB에 접근해야 한다 -> 서블릿으로 간다
		response.sendRedirect("select");
	}
}
