package chap04.examples;

public class ForPrintFrom1To10Example {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) { // 1부터 10까지

			System.out.println(i);
		}
		for (int i = 10; i >= 1; i--) { // 10부터 1까지

			System.out.println(i);
		}
		int i = 10; // 적절한 곳에 선언만 된다면 괄호 안에서 빼도 된다.
		for (; i >= 1;) { // 적절한 곳에 선언만 된다면 괄호 안에서 빼도 된다.
			System.out.println(i);
			i--; // 적절한 곳에 선언만 된다면 괄호 안에서 빼도 된다.
		}
		
		int j = 0, k = 10; // {} 밖에 선언되어야 for문이 끝나도 사용될 수 있다.
		for (; j < 10 && k > 0; j++, k--) { // 변수를 여러개 선언하거나 여러개를 변환시키는 것도 가능
			System.out.println(j + ", " + k);
		}
		System.out.println(j);
		System.out.println(k);
	}
}
