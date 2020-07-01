package kr.co.utils;

import java.io.UnsupportedEncodingException;

public class Utils {

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
