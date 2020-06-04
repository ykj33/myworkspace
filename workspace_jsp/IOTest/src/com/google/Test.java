package com.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;

public class Test {

	public void me4() {
		File f1 = new File("C:" + File.separator + "no.txt");
		InputStream in = null;
		// 바이트 스트림과 문자 스트림 연결
		InputStreamReader isr = null;
		BufferedReader br = null;

		try {
			in = new FileInputStream(f1);
			// 바이트 스트림과 문자 스트림 체이닝
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);

			while (true) {
				String msg = br.readLine();
				if (msg == null) {
					break;
				}
				System.out.println(msg);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (in != null) {
					in.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		// String이 연결되어 있는 상태에서 이름이 바뀌면 안되므로 while문이 끝나야 한다.
		f1.renameTo(new File("C:", "nono.txt"));
	}

	public void me3() {
		Writer out = null;
		BufferedWriter bw = null;

		Reader in = null;
		BufferedReader br = null;

		try {
			// 없으면 새로 만든다.
			out = new FileWriter("C:" + File.separator + "no.txt");
			bw = new BufferedWriter(out);

			bw.write("hello");
			bw.write(System.getProperty("line.separator"));
			bw.write("world");
			bw.write(System.getProperty("line.separator"));
			bw.write("good");
			bw.write(System.getProperty("line.separator"));
			// 문자스트림에선 출력을 먼저 하고 입력을 읽어올 때는 flush()메소드가 호출되어야 한다.
			bw.flush();

			in = new FileReader("C:" + File.separator + "no.txt");
			br = new BufferedReader(in);

			while (true) {
				String msg = br.readLine();
				if (msg == null) {
					break;
				}
				System.out.println(msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (out != null) {
					out.close();
				}
				if (br != null) {
					br.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void me2() {
		File f1 = new File("C:", "test112.txt");
		File f2 = new File("C:", "copytest113.txt");

		Reader in = null;
		BufferedReader br = null;
		Writer out = null;
		// 실제로는 잘 쓰이지 않는다.
		BufferedWriter bw = null;
		try {

			in = new FileReader(f1);
			br = new BufferedReader(in);
			out = new FileWriter(f2);
			bw = new BufferedWriter(out);

			String msg = "";
			while (true) {
				// 한줄 씩 읽기에 readLine()
				msg = br.readLine();
				if (msg == null) {
					break;
				}

				bw.write(msg);
				// 이 코드가 들어가야 줄바꿈이 된다.
//				bw.newLine();
				// 해당 코드로 어느 OS에서도 줄바꿈이 된다.
				bw.write(System.getProperty("line.separator"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (in != null) {
					in.close();
				}
				if (bw != null) {
					bw.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// 잘 쓰이지 않는 코드
	public void me1() {
		File f1 = new File("C:" + File.separator + "test112.txt");
		File f2 = new File("C:" + File.separatorChar + "copytest112.txt");

		Reader in = null;
		Writer out = null;

		try {
			in = new FileReader(f1);
			out = new FileWriter(f2);
			char[] arr = new char[64];
			int leng = -1;
			while (true) {
				// 0에서 배열의 길이까지 읽어오자.
				leng = in.read(arr, 0, arr.length);
				if (leng == -1) {
					break;
				}
				out.write(arr, 0, arr.length);
			}

		} catch (

		Exception e) {
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
