package free.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.dao.FreeDAO;
import free.domain.FreeDTO;
import share.Command;
import share.CommandAction;

public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String ftitle = request.getParameter("ftitle");
		String fcontent = request.getParameter("fcontent");
		
		FreeDAO dao = new FreeDAO();
		dao.insert(new FreeDTO(0, ftitle, fcontent, id, null, 0, 0, 0, 0));
		return new CommandAction(true, "freelist.do");
	}

}
