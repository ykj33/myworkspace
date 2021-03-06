package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;

public class UpdateUICommand implements Command {
	// 서블릿으로 가서 UpdateCommand로 이동하도록 함
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		id는 파라미터에서 받아와야 한다.
		String id = request.getParameter("id");

		MemberDAO dao = new MemberDAO();
//		selectById()메소드를 사용해서 값을 가져오나 select를 쓰는건 이상하므로 updateUI를 새로 만들어 쓴다.
		MemberDTO dto = dao.updateUI(id);
		request.setAttribute("dto", dto);
//		request.getRequestDispatcher("update.jsp").forward(request, response);
		return new CommandAction(false, "update.jsp");
	}
}
