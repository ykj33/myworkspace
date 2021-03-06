package kr.co.ca;

import kr.co.lg.MyThread;
import kr.co.lg.SyncTest;

public class MainEx9 {
	public static void main(String[] args) {
		SyncTest st = new SyncTest();
		System.out.println(st.num);
		
		MyThread t1 = new MyThread(st);
		MyThread t2 = new MyThread(st);
		
		// runnable 상태이므로 실행되지 않는다.
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(st.num);
	}
}
