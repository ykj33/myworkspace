package com.naver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dto.MemberDTO;

public class selectCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. client가 보내준 데이터 획득 및 가공
		// 지금은 받아오는 데이터가 없음
		// 2. DAO 객체 생성 및 해당 메소드 호출
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.selectAll();

		// 3. jsp에 뿌려줄 데이터 바인딩(저장)
		// list 데이터를 "list"에 넣어준다.
		// 일반적으로 key와 value는 같게 해준다.
		request.setAttribute("list", list);

		// 4. forwarding 작업
		// 리다이렉트를 하면 request에 저장된 데이터가 사라짐
		// dispatcher로 보내면 데이터 유지
		RequestDispatcher dis = request.getRequestDispatcher("select.jsp");
		dis.forward(request, response);
	}

}
