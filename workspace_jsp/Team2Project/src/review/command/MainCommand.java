package review.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.dao.FreeDAO;
import free.domain.FreeDTO;
import review.dao.ReviewDAO;
import review.domain.ReviewDTO;
import share.Command;
import share.CommandAction;

public class MainCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReviewDAO rdao = new ReviewDAO();
		List<ReviewDTO> rlist = rdao.list();
		request.setAttribute("list", rlist);
		FreeDAO fdao = new FreeDAO();
		List<FreeDTO> flist = fdao.selectAll();
		request.setAttribute("freelist", flist);
		return new CommandAction(false, "main.jsp");
	}

}
