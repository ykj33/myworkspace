package free.command;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import free.dao.FreeDAO;
import free.domain.FreeDTO;
import review.domain.UploadDTO;
import share.Command;
import share.CommandAction;

public class UploadCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uploadPath = this.getClass().getResource("").getPath();
		uploadPath = uploadPath.substring(1, uploadPath.indexOf(".metadata")) + "Team2Project" + File.separator
				+ "WebContent" + File.separator + "upload" + File.separator + "free";
		File uploadFolder = new File(uploadPath);
		if (!uploadFolder.exists()) {
			uploadFolder.mkdir();
		}

		MultipartRequest multi = new MultipartRequest(request, uploadPath, 10 * 1024 * 1024, "utf-8",
				new DefaultFileRenamePolicy());

		String id = multi.getParameter("id");
		String ftitle = multi.getParameter("ftitle");
		String fcontent = multi.getParameter("fcontent");
		String fileName = multi.getFilesystemName("file");
		String orgFileName = multi.getOriginalFileName("file");

		FreeDAO dao = new FreeDAO();
		dao.insert(new FreeDTO(0, ftitle, fcontent, id, null, 0, 0, 0, 0),
				new free.domain.UploadDTO(fileName, orgFileName, -1));
		return new CommandAction(true, "freelist.do");
	}

}
