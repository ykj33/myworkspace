package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;

public class ReplyCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int orgNum = -1;
		if (sNum != null) {
			orgNum = Integer.parseInt(sNum);
		}
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		BoardDAO dao = new BoardDAO();
		// 그냥 num을 받으면 원글의 num이므로 -1을 붙여준다.
		// 부모의 num값을 알고 있으면 다른 값들도 구할 수 있다.
		BoardDTO dto = new BoardDTO(-1, writer, title, content, null, 0, 0, 0, 0);
		dao.reply(orgNum, dto);
		return new CommandAction(true, "list.do");
	}

}
