package com.naver;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File uploadFolder = new File("c:" + File.separator + "upload");
		// 폴더 만들기
		if (!uploadFolder.exists()) {
			uploadFolder.mkdir();
		}
		String title = "";
		// cos.jar에서 관리하는 별도의 파일이름
		// 같은 이름의 파일이 들어올 수도 있으므로 시스템에서 따로 파일명을 관리한다.
		String fileName = "";
		// 오리지널 파일 이름
		String orgFileName = "";

		// request, 파일 저장 위치, 용량, 인코딩, 파일 이름 중복시 정책
		// 이 객체를 만듦으로써 파일 업로드는 끝
		MultipartRequest multi = new MultipartRequest(request, "c:" + File.separator + "upload", 10 * 1024 * 1024,
				"utf-8", new DefaultFileRenamePolicy());

		title = multi.getParameter("title");
		// upload.jsp의 첨부파일 이름이 file이기에 file을 받아줌
		// 다운로드를 위해선 오리지널 이름이 아니라 시스템이 관리하는 파일이름이 필요
		// 하지만 사용자 입장에선 파일 이름이 다를 수 있으므로 둘 다 필요
		fileName = multi.getFilesystemName("file");
		orgFileName = multi.getOriginalFileName("file");
		request.setAttribute("fileName", fileName);
		request.setAttribute("orgFileName", orgFileName);
		
		
		request.getRequestDispatcher("check.jsp").forward(request, response);

	}

}
