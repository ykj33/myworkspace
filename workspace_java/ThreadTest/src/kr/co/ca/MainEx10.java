package kr.co.ca;

import kr.co.lg.Sum;
import kr.co.lg.YourThread;

public class MainEx10 {
	public static void main(String[] args) {
		Sum sum = new Sum();

		// ����ȭ������ ���� ���ϴ� ���� ���� �� ����.
		YourThread y1 = new YourThread(0, 5000, sum);
		YourThread y2 = new YourThread(5001, 10000, sum);
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
