package com.naver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 업로드한 파일 확인
		String fileName = request.getParameter("fileName");
		// 파일들이 업로드 되는 곳
		String uploadPath = "C:" + File.separator + "upload";
//		실제로는 이렇게 uploadPath를 가져와야 한다.
//		String uploadPath = request.getServletContext().getRealPath("img");

		// file separator가 필요
		String filePath = uploadPath + File.separator + fileName;
		File f = new File(filePath);

		// 어떤 형태의 파일인지 모르므로 모두 받을 수 있는 바이트 스트림으로
		InputStream in = null;
		try {
			// 스트림 연결
			in = new FileInputStream(f);

			// 다운로드 하기 위한 환경설정

			// mime type을 확인한다.
			String sMimeType = getServletContext().getMimeType(filePath);
			if (sMimeType == null) {
				// mimetype이 지정되지 않았을 때 (어떤 타입의 파일인지 알 수 없을 때) 그냥 다운로드 받게 한다.
				sMimeType = "application/octet-stream";
			}
			// 컨텐츠의 타입을 특정해준다.
			response.setContentType(sMimeType);

			// filename을 utf-8 byte 형태로 되어있는 것을 다시 브라우저에 맞게 8859_1로 바꾼다.
			String encoding = new String(fileName.getBytes("utf-8"), "8859_1");

			// 헤더값 설정
			response.setHeader("Content-Disposition", "attachment;filename=" + encoding);

			// 컨테이너가 관리하고 있는 자원이므로 함부로 닫으면 안된다.
			ServletOutputStream out = response.getOutputStream();

			byte[] arr = new byte[1024];
			int leng = -1;
			while (true) {
				// 먼저 다운로드 시켜줄 파일을 읽어온다.
				leng = in.read(arr, 0, arr.length);
				if (leng == -1) {
					break;
				}
				// 다운로드 시켜준다.
				out.write(arr, 0, leng);
			}
			// 확실하게 하기 위해 flush()까지.
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
