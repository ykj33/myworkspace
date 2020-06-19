package free.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.dao.FreeDAO;
import free.domain.FreeDTO;
import review.domain.PageTO;
import share.Command;
import share.CommandAction;

public class listPageCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String scurPage = request.getParameter("curPage");
		int curPage = 1;
		if (scurPage != null) {
			curPage = Integer.parseInt(scurPage);
		}
		FreeDAO dao = new FreeDAO();
		PageTO to = dao.page(curPage);
		request.setAttribute("list", to.getList());
		return new CommandAction(false, "freelist.jsp");
	}

}
