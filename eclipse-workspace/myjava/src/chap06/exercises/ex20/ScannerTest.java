package chap06.exercises.ex20;

import java.util.Scanner;

public class ScannerTest {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("숫자>");
	int i = scanner.nextInt();
	
	System.out.println("받은 숫자 " + i);
	
	System.out.println("문자열>");
	String s = scanner.nextLine();
	System.out.println("받은 문자열" + s);
}
}
