package chap10.lecture.runtimeException.numberFormatException;

public class NumberFormatExceptionSample {
	public static void main(String[] args) {
		String a = "abcd";
		int i = Integer.parseInt(a);
		System.out.println(i + 1000);
	}
}
