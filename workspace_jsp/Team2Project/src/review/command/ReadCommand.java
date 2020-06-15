package review.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.dao.ReviewDAO;
import review.domain.ReviewDTO;
import review.domain.UploadDTO;
import share.Command;
import share.CommandAction;

public class ReadCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int num = -1;
		if (sNum != null) {
			num = Integer.parseInt(sNum);
		}
		ReviewDAO dao = new ReviewDAO();
		ReviewDTO list = dao.read(num);
		UploadDTO upload= dao.imgSelect(num);
		request.setAttribute("upload", upload);
		request.setAttribute("list", list);
		
		return new CommandAction(false, "reviewread.jsp");
	}

}
