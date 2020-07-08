package kr.co.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class Utils {

	public static String saveFile(String originalName, MultipartFile file) throws Exception {

		String newName = Utils.makeNewName(originalName);
		// 파일이 저장될 곳, 새로운 이름으로 넣어준다.
		File target = new File("C:" + File.separator + "upload", newName);
		// 파일을 업로드하는 코드
		FileCopyUtils.copy(file.getBytes(), target);
		return newName;
	}

	public static String makeNewName(String originalName) {
		// 중복되지 않는 새로운 이름이 만들어진다.
		UUID uid = UUID.randomUUID();
		String newName = uid.toString() + "_" + originalName;
		return newName;
	}

	public static String toKor(String msg) {

		try {
			return new String(msg.getBytes("8859_1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
			// 데이터가 없으면 nullpointer가 발생하므로 null을 반환하도록 해준다.
			return null;
		}
	}
}
