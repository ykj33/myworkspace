package kr.co.ca;

public class MainEx {
	public static void main(String[] args) {
		// 현재 쓰레드
		Thread ct = Thread.currentThread();
		String ctname = ct.getName();
		System.out.println(ctname);
	}
}
