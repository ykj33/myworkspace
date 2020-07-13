package kr.co.ca;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.service.BoardService;
import kr.co.utils.Utils;

@Controller
public class UploadAjaxController {
	private String uploadPath = "C:" + File.separator + "upload";
	
	@Inject
	private BoardService bService;

	@RequestMapping(value = "/uploadajax", method = RequestMethod.GET)
	public void uploadajax() {

	}
	
	@ResponseBody
	@RequestMapping(value = "/getAttach/{bno}", method = RequestMethod.GET)
	public List<String> getAttach(@PathVariable("bno") Integer bno) {
		return bService.getAttach(bno);
	}

	@ResponseBody
	@RequestMapping(value = "/deletefile", method = RequestMethod.POST)
	public String deletefile(String filename, String originalfilename) {
		// /로 되어있는 것을 \로 변경
		filename.replace('/', File.pathSeparatorChar);

		// 이미지 파일 확인을 위한 확장자 도출
		int idx = filename.lastIndexOf(".");
		String format = filename.substring(idx + 1);
		MediaType mType = Utils.getMediaType(format);

		// 이미지 파일인 경우
		if (mType != null) {
			// 오리지널 네임을 추출해서
			String pre = filename.substring(0, 12);
			String suf = filename.substring(14);

			String oriname = pre + suf;

			// 객체를 하나 만들어 삭제한다.
			File oriFile = new File(uploadPath + oriname);
			oriFile.delete();
		}

		File f = new File(uploadPath + filename);
		f.delete();
		return "success";
	}

	// ajax사용, 데이터를 넘겨주기 때문에 responsebody
	@ResponseBody
	@RequestMapping(value = "/displayfile", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayfile(String filename) {
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		try {
			// 파일 확장자 확인
			int idx = filename.lastIndexOf(".");
			String format = filename.substring(idx + 1);
			MediaType mType = Utils.getMediaType(format);
			HttpHeaders headers = new HttpHeaders();
			// uploadPath는 따로 관리, filename안에 나머지 path가 다 있다.
			// File class를 만들어서 넣는게 더 실용적
			// 만들어 저장해놨던 thumbnail과 String을 연결
			in = new FileInputStream(uploadPath + filename);

			// header에 minetype지정
			if (mType != null) {
				// 이미지 출력
				headers.setContentType(mType);
			} else {

				// 다운로드 관련 코드
				// UUID를 제외한 이름
				idx = filename.indexOf("_");
				String originalname = filename.substring(idx + 1);
				// 다운로드를 가능하게 해주는 mine type
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				// \"를 넣어 ""가 헷갈리지 않도록 한다.
				headers.add("Content-disposition",
						"attachment;filename=\"" + new String(originalname.getBytes("UTF-8"), "ISO-8859-1"));

			}
			// 썸네일이 가지고 있는 바이트 정보, 헤더 정보, 통신상태코드
			// img src에 소스를 넣어줌
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// 실패한다면 통신상태만 알려주고 끝난다.
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return entity;
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
