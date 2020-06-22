package free.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.dao.FreeDAO;
import free.domain.FreeDTO;
import free.domain.UploadDTO;
import share.Command;
import share.CommandAction;

public class readCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sFnum = request.getParameter("fnum");
		int fnum = -1;
		if (sFnum != null) {
			fnum = Integer.parseInt(sFnum);
		}
		FreeDAO dao = new FreeDAO();
		FreeDTO read = dao.read(fnum);
		UploadDTO upload = dao.imgSelect(fnum);
		request.setAttribute("read", read);
		request.setAttribute("upload", upload);
		return new CommandAction(false, "freeread.jsp");
	}

}
