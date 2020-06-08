package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;

public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BoardDAO dao = new BoardDAO();
		// num을 내가 입력하지 않는다.
		dao.insert(new BoardDTO(-1, writer, title, content, null, 0, 0, 0, 0));
		
		// 데이터 100개 한번에 넣기.
//		for (int i = 0; i < 100; i++) {
//			dao.insert(new BoardDTO(-1, "writer" + i, "title" + i, "content" + i, null, 0, 0, 0, 0));
//
//			// 쓰레드를 사용하여 jamming을 방지한다.
//			try {
//				Thread.sleep(50);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return new CommandAction(true, "list.do");
	}

}
