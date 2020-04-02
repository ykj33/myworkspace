package chap04.examples;

public class WhileSumFrom1To100Example {

	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		while (i <= 100) {
			sum += i;
			i++;
		}
		System.out.println("1~" + (i - 1) + "합 : " + sum); // i가 ++되었으므로 1을 빼준다.

	}

}
