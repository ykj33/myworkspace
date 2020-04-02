package chap04.exercises;

public class Exercise03 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			if (i % 3 == 0) {
				sum = sum + i;
			}

		}
		System.out.println("3의 배수의 합 : " + sum);

		int sum2 = 0;
		for (int i = 0; i <= 100; i = i + 3) {
			sum2 = sum2 + i;
		}
		System.out.println("3의 배수의 합 : " + sum2);
	}

}
