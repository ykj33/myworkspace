package com.naver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {

	// 배열로 하므로 성능이 훨씬 빠르다.
	public void me2() {
		File f1 = new File("C:" + File.separator + "test.jpg");
		File f2 = new File("C:", "copytest.jpg");

		InputStream in = null;
		OutputStream out = null;

		// 값을 받을 배열 준비
		byte[] arr = new byte[512];

		try {
			in = new FileInputStream(f1);
			out = new FileOutputStream(f2);
			while (true) {
				// 데이터를 arr만큼 읽어와서 leng에 넣어준다.
				int leng = in.read(arr);
				if (leng == -1) {
					break;
				}
				// 배열의 0번째 인덱스부터 leng까지 읽어오라.
				out.write(arr, 0, leng);
			}
			System.out.println("파일 복사 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void me1() {
		File f1 = new File("C:" + File.separator + "test.jpg");
		File f2 = new File("C:", "copytest.jpg");

		// InputStream은 추상클래스이기 때문에 직접적 객체 만들기 불가능
		InputStream in = null;
		OutputStream out = null;
		// byte가 아닌 int형으로 보낸다.
		// 더 이상 읽어올 게 없으면 -1을 반환함
		int what = -1;

		try {
			in = new FileInputStream(f1);
			out = new FileOutputStream(f2);

			while (true) {
//				읽어오고
				what = in.read();
				// 더 이상 읽어올게 없으면 -1을 반환
				if (what == -1) {
					break;
				}
				// 읽어온 것을 쓴다.
				out.write(what);
			}
			System.out.println("파일 복사 종료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
