package free.command;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import free.dao.FreeDAO;
import member.dao.MemberDAO;
import member.domain.MemberDTO;
import review.dao.ReviewDAO;
import review.domain.UploadDTO;
import share.Command;
import share.CommandAction;

public class ManagerDeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sFnum = request.getParameter("fnum");
		int fnum = -1;
		if (sFnum != null) {
			fnum = Integer.parseInt(sFnum);
		}

		HttpSession session = request.getSession();
		if (session != null) {
			MemberDTO dto = (MemberDTO) session.getAttribute("login");
			if (dto != null) {
				if (dto.getProperty().equals("admin") || dto.getProperty().equals("manager")) {
					FreeDAO dao = new FreeDAO();

					String uploadPath = this.getClass().getResource("").getPath();
					uploadPath = uploadPath.substring(1, uploadPath.indexOf(".metadata")) + "Team2Project"
							+ File.separator + "WebContent" + File.separator + "upload" + "free";

					free.domain.UploadDTO uDto = dao.imgSelect(fnum);

//					String fileName = uDto.getFileName();
//
//					String filePath = uploadPath + File.separator + fileName;
//
//					File file = new File(filePath);
//
//					if (file.exists())
//						file.delete();

					dao.delete(fnum);
				}
			}

		}

		return new CommandAction(true, "freelist.do");
	}

}
