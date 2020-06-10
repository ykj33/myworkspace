package review.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.dao.ReviewDAO;
import review.domain.ReviewDTO;
import share.Command;
import share.CommandAction;

public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("writer");
		String category = request.getParameter("category");

		String sStarpoint = request.getParameter("starpoint");
		int starpoint = -1;
		if (sStarpoint != null) {
			starpoint = Integer.parseInt(sStarpoint);
		}

		ReviewDAO dao = new ReviewDAO();
		dao.insert(new ReviewDTO(-1, title, content, id, category, null, 0, starpoint));

		return new CommandAction(true, "reviewlist.do");
	}

}
