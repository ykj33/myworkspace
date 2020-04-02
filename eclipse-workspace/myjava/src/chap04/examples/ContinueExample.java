package chap04.examples;

public class ContinueExample {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0) { // 홀수
				continue;
			}
			System.out.println(i);
		}
	}
}
