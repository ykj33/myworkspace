package chap04.examples;

public class IfDiceExample2 {
	public static void main(String[] args) {
		int num1 = (int) (Math.random() * 6) + 1;
		int num2 = (int) (Math.random() * 6) + 1;

		if (num1 == num2) {
			System.out.println("1번 주사위: " + num1);
			System.out.println("2번 주사위: " + num2);
			System.out.println("당첨");
		} else {
			System.out.println("1번 주사위: " + num1);
			System.out.println("2번 주사위: " + num2);
			System.out.println("낙첨");
		}
	}
}
