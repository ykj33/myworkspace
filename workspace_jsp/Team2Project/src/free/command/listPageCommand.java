package free.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.dao.FreeDAO;
import free.domain.FreeDTO;
import share.Command;
import share.CommandAction;

public class listPageCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FreeDAO dao = new FreeDAO();
		List<FreeDTO> list = dao.selectAll();
		request.setAttribute("list", list);
		return new CommandAction(false, "freelist.jsp");
	}

}
