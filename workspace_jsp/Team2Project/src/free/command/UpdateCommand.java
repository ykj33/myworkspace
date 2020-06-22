package free.command;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

import free.dao.FreeDAO;
import free.domain.FreeDTO;
import free.domain.UploadDTO;
import share.Command;
import share.CommandAction;

public class UpdateCommand implements Command {

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

		String newFileName = multi.getFilesystemName("file");
		String sFnum = multi.getParameter("fnum");
		int fnum = -1;
		if (sFnum != null) {
			fnum = Integer.parseInt(sFnum);
		}
		String id = multi.getParameter("id");
		String ftitle = multi.getParameter("ftitle");
		String fcontent = multi.getParameter("fcontent");

		FreeDAO dao = new FreeDAO();
		UploadDTO dto = dao.imgSelect(fnum);
		String fileName = null;
		String orgFileName = null;

		if (newFileName != null) {
			fileName = dto.getFileName();
			String filePath = uploadPath + File.separator + fileName;
			orgFileName = multi.getOriginalFileName("file");
			File file = new File(filePath);

			if (file.exists()) {
				file.delete();
			}
		}

		dao.update(new FreeDTO(fnum, ftitle, fcontent, id, null, -1, -1, 0, 0),
				new UploadDTO(newFileName, orgFileName, fnum));
		return new CommandAction(true, "freelist.do");
	}

}
