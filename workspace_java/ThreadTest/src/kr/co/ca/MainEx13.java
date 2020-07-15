package kr.co.ca;

import com.naver.UserThread1;

public class MainEx13 {
public static void main(String[] args) {
	System.out.println("main start");
	
	// 데몬스레드
	// 메인스레드가 끝나면 할일이 끝나지 않았어도 끝난다.
	Thread t = new UserThread1();
	t.setDaemon(true);
	t.start();
	
	System.out.println("main end");
}
}
