package com.naver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {

	public void me4() {
		File f1 = new File("C:" + File.separator + "test112.txt");
		File f2 = new File("C:", "copytest112.txt");

		InputStream in = null;
		BufferedInputStream bis = null;
		OutputStream out = null;
		BufferedOutputStream bos = null;
		int what = -1;
		try {
			in = new FileInputStream(f1);
			bis = new BufferedInputStream(in);
			out = new FileOutputStream(f2);
			bos = new BufferedOutputStream(out);
			while (true) {
				what = bis.read();
				if (what == -1) {
					break;
				}
				bos.write(what);
			}
			System.out.println("파일 복사 종료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
				if (out != null) {
					out.close();
				}
				if (bis != null) {
					bis.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void me3() {
		File f1 = new File("C:" + File.separator + "show.jpg");
		File f2 = new File("C:", "copyshow.jpg");

		InputStream in = null;
//		대문자로 BIS라고 하면 자동완성
		BufferedInputStream bis = null;
		OutputStream out = null;
		BufferedOutputStream bos = null;
		try {
			in = new FileInputStream(f1);
			// inputstream 객체를 넣어 체이닝을 해준다.
			bis = new BufferedInputStream(in);
			out = new FileOutputStream(f2);
			bos = new BufferedOutputStream(out);
			int what = -1;
			while (true) {
				what = bis.read();
				if (what == -1) {
					break;
				}
				bos.write(what);
			}
			System.out.println("파일 복사 종료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 필터 스트림 먼저 제거
				if (bos != null) {
					bos.close();
				}

				// 이후 노드 스트림 제거필요
				if (out != null) {
					out.close();
				}
				if (bis != null) {
					bis.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

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
