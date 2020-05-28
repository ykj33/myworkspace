package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.dao.MemberDAO;
import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;

public class DeleteCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		HttpSession session = request.getSession(false);
		// 일단 세션이 있는지 확인
		if (session != null) {
			LoginDTO loginDTO = (LoginDTO) session.getAttribute("login");
			// 세션이 있다면 그게 해당 회원 아이디를 가지고 있는 것인지 확인
			if (loginDTO != null) {
				// 두개의 값이 같다면 삭제
				if (loginDTO.getId().equals(id)) {
					MemberDAO dao = new MemberDAO();
					dao.delete(id);
					response.sendRedirect("select.do");
				} else {
					response.sendRedirect("loginui.do");
				}
			} else {
				response.sendRedirect("loginui.do");
			}
		} else {
			response.sendRedirect("loginui.do");
		}
	}
}
