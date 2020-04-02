package chap04.examples;

public class ForFloatCounterExample {
	public static void main(String[] args) {
		for (float x = 0.1F; x <= 1.0F; x += 0.1F) { // 실수 형은 정확하게 표현할 수 없기 때문에 for문에 어울리지 않는다.
			System.out.println(x);
		}
	}
}
