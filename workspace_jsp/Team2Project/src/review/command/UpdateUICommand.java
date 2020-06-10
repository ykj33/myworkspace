package review.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.dao.ReviewDAO;
import review.domain.ReviewDTO;
import share.Command;
import share.CommandAction;

public class UpdateUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int num = -1;
		if (sNum != null) {
			num = Integer.parseInt(sNum);
		}

		ReviewDAO dao = new ReviewDAO();
		ReviewDTO dto = dao.updateUI(num);

		request.setAttribute("dto", dto);

		return new CommandAction(false, "reviewupdate.jsp");
	}

}
