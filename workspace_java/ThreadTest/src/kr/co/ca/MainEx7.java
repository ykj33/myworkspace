package kr.co.ca;

import com.naver.UserRunnable1;
import com.naver.UserThread1;

public class MainEx7 {
	public static void main(String[] args) {
		System.out.println("main start");
		
		UserThread1 my = new UserThread1();
		my.start();
		
		// my�� �����Ű�� ���� �Ķ���ͷ� �ش�.
		UserRunnable1 ur1 = new UserRunnable1(my);
		Thread you = new Thread(ur1);
		you.start();
		System.out.println("main end");
	}
}
