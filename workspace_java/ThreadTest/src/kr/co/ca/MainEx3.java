package kr.co.ca;

import com.naver.UserRunnable1;

public class MainEx3 {
	public static void main(String[] args) {
		System.out.println("main start");
		UserRunnable1 ur1 = new UserRunnable1();
		Thread urt1 = new Thread(ur1);
		urt1.start();
		System.out.println("main end");
	}
}
