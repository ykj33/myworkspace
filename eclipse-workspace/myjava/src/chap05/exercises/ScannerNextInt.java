package chap05.exercises;

import java.util.Scanner;

public class ScannerNextInt {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력:");
		int i = scanner.nextInt();
		System.out.println(i * i);
		
	}
}
