package kr.co.ca;

public class MainEx8 {
	public static void main(String[] args) {
		// 익명 클래스로 쓰레드선언 가능
		// 통신과 관련된 코드에 주로 사용
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(i);
				}

			}
		}).start();
	}
}
