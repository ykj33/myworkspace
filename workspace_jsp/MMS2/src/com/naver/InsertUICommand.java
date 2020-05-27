package com.naver;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertUICommand implements Command {
	// 글쓰기를 눌렀을 때 입력할 수 있는 페이지로 포워딩해줌
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("insert.jsp").forward(request, response);

	}
}
