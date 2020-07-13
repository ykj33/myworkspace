package kr.co.ca;

import java.io.File;
import java.io.IOException;

import org.aspectj.apache.bcel.classfile.Field;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import kr.co.utils.Utils;

@Controller
public class UploadController {
	private String uploadPath = "C:" + File.separator + "upload";

	@RequestMapping(value = "/uploadform", method = RequestMethod.GET)
	public void uploadform() {

	}

	@RequestMapping(value = "/uploadform", method = RequestMethod.POST)
	public void uploadform(MultipartHttpServletRequest request, Model model) throws Exception {
		// getFile을 통해 파일을 받는다.
		MultipartFile file = request.getFile("file");
		String originalName = file.getOriginalFilename();
		String fileName = Utils.saveFile(originalName, file, uploadPath);
		// 다시 JSP 파일로 값을 넘겨준다.
		model.addAttribute("fileName", fileName);
	}
}
