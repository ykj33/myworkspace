package kr.co.ca;

import com.naver.UserThread1;

public class MainEx2 {
	public static void main(String[] args) {
		
		System.out.println("main start"); // ���� ���� ����, ���Ĵ� ������ ���� ����
		// ������ '��ü' ����
		UserThread1 ut1 = new UserThread1();
		ut1.start();
		
		System.out.println("main end");
	}
}
