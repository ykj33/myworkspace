package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	// 반환형을 CommandAction으로 한다.
	CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
