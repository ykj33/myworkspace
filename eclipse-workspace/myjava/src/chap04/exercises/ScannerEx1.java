package chap04.exercises;

import java.util.Scanner;

public class ScannerEx1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("입력 >");

		String n = scanner.nextLine(); // 입력받을 준비, 1줄을 다 입력받는다. 입력 받은 것을 반환
		System.out.println("입력값 : " + n);

		int i = Integer.parseInt(n);
		double d = Double.parseDouble(n);

		System.out.println("정수값 : " + i);
		System.out.println("실수값 : " + d);
	}
}
