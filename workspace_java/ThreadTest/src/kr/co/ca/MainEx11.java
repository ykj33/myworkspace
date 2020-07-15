package kr.co.ca;

import kr.co.lg.Sum;
import kr.co.lg.Sum2;
import kr.co.lg.YourThread;
import kr.co.lg.YourThread2;

public class MainEx11 {
	public static void main(String[] args) {
		Sum2 sum = new Sum2();

		// 동기화문제로 인해 원하는 값을 뽑을 수 없다.
		YourThread2 y1 = new YourThread2(0, 5000, sum);
		YourThread2 y2 = new YourThread2(5001, 10000, sum);
		y1.start();
		y2.start();
		try {
			y1.join();
			y2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(sum.num1);
	}
}
