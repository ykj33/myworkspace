package kr.co.ca;

import com.naver.UserThread1;

public class MainEx13 {
public static void main(String[] args) {
	System.out.println("main start");
	
	// ���󽺷���
	// ���ν����尡 ������ ������ ������ �ʾҾ ������.
	Thread t = new UserThread1();
	t.setDaemon(true);
	t.start();
	
	System.out.println("main end");
}
}
