package kr.co.ca;

import com.naver.UserThread1;

public class MainEx2 {
	public static void main(String[] args) {
		
		System.out.println("main start"); // 가장 먼저 실행, 이후는 쓰레드 개별 실행
		// 쓰레드 '객체' 생성
		UserThread1 ut1 = new UserThread1();
		ut1.start();
		
		System.out.println("main end");
	}
}
