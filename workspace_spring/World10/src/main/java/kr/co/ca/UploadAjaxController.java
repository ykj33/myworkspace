package kr.co.ca;

import java.io.File;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.utils.Utils;

@Controller
public class UploadAjaxController {
	private String uploadPath = "C:" + File.separator + "upload";

	@RequestMapping(value = "/uploadajax", method = RequestMethod.GET)
	public void uploadajax() {

	}

	// @ResponseBody 어노테이션을 붙여야 한다. 한글은 깨질 것
	@ResponseBody
	@RequestMapping(value = "/uploadajax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String uploadajax(MultipartHttpServletRequest request) throws Exception {
		MultipartFile file = request.getFile("file");
		String originalName = file.getOriginalFilename();
		String saveFile = Utils.saveFile(originalName, file, uploadPath);
		return saveFile;
	}
}
