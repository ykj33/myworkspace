package kr.co.ca;

import com.naver.UserRunnable1;
import com.naver.UserThread1;

public class MainEx5 {
	public static void main(String[] args) {
		System.out.println("main start");
		UserThread1 ut1 = new UserThread1();
		ut1.start();
		
		UserRunnable1 ur1 = new UserRunnable1();
		Thread urt = new Thread(ur1);
		urt.start();
		
		// A스레드가 B 스레드보다 일찍 끝나게 하고 싶다 - B영역에서 join()메소드 호출
		// ut1 쓰레드가 항상 main 쓰레드보다 일찍 끝나게 된다.		
		try {
			ut1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main end");
	}
}
