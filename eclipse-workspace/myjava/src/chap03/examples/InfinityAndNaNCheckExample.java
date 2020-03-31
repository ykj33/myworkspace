package chap03.examples;

public class InfinityAndNaNCheckExample {
	public static void main(String[] args) {
		int x = 5;
		double y = 0.0;

		double z = x / y;
		// double z = x % y;

		System.out.println(Double.isInfinite(z));
		System.out.println(Double.isNaN(z));

		System.out.println(z + 2); // 문제가 되는 코드

		if (Double.isInfinite(z) || Double.isNaN(z)) // 연산의 결과가 Infinity이거나 NaN일 경우 다음 연산 수행 X

		{
			System.out.println("값 산출  불가");
		} else {
			System.out.println(z + 2);
		}
	}
}