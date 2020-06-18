package free.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

import free.dao.FreeDAO;
import free.domain.FreeDTO;
import share.Command;
import share.CommandAction;

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sFnum = request.getParameter("fnum");
		int fnum = -1;
		if (sFnum != null) {
			fnum = Integer.parseInt(sFnum);
		}
		String id = request.getParameter("id");
		String ftitle = request.getParameter("ftitle");
		String fcontent = request.getParameter("fcontent");

		FreeDAO dao = new FreeDAO();
		dao.update(new FreeDTO(fnum, ftitle, fcontent, id, null, -1, -1, 0, 0));
		return new CommandAction(true, "freelist.do");
	}

}
