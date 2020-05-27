package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;

public class SelectCommand implements Command {
	// 양식만이 있을 뿐 servlet에 접근하여 dao에 접근하여 db에 접근하여 데이터를 가져와야 한다.
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.selectAll();
		// 데이터 바인딩을 하여 보내주어야 한다.
		request.setAttribute("list", list);

		// 바인딩 된 데이터가 있기 때문에 dispatcher로 보내야한다.
		request.getRequestDispatcher("select.jsp").forward(request, response);

	}
}
