package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.BoardDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.PageTO;

public class ListPageCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String scurPage = request.getParameter("curPage");
		// 기본적으로 1페이지에서 시작한다.
		int curPage = 1;
		if (scurPage != null) {
			curPage = Integer.parseInt(scurPage);
		}

		BoardDAO dao = new BoardDAO();
		PageTO to = dao.page(curPage);
		request.setAttribute("to", to);
		// list를 어떻게 어디서 호출할지에 따라 결정되는 코드
		// list.jsp에서 to.list로 값을 받을 것인가 아니면 아래의 코드를 추가할 것인가
		request.setAttribute("list", to.getList());

		return new CommandAction(false, "list.jsp");
	}

}
