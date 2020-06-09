package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;

public class ReplyUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 어차피 주소 창에 값을 넘겨주는 역할만 하므로 int로 바꿀 필요는 없다.
		String num = request.getParameter("num");
		return new CommandAction(false, "reply.jsp?num=" + num);
	}

}
