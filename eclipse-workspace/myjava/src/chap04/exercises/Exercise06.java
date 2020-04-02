package chap04.exercises;

public class Exercise06 {
	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) { // 초기값과 비교하는 값의 차이가 별이 찍히는 개수가 된다.
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i <= 5; i++) {
			for (int j = 4; j >= i; j--) { // 초기값과 비교하는 값의 차이가 별이 찍히는 개수가 된다.
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
