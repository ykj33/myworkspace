package free.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.dao.FreeDAO;
import free.domain.FreeDTO;
import share.Command;
import share.CommandAction;

public class UpdateUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sFnum = request.getParameter("fnum");
		int fnum = -1;
		if (sFnum != null) {
			fnum = Integer.parseInt(sFnum);
		}
		FreeDAO dao = new FreeDAO();
		FreeDTO list = dao.selectByFnum(fnum);
		request.setAttribute("list", list);
		return new CommandAction(false, "freeupdate.jsp");
	}

}
