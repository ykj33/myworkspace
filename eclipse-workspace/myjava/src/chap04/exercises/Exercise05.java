package chap04.exercises;

public class Exercise05 {
	public static void main(String[] args) {
		for (int x = 0; x <= 10; x++) {
			for (int y = 0; y <= 10; y++) {
				int sum = (4 * x) + (5 * y);
				if (sum == 60) {
					System.out.println("(" + x + "," + y+")");
				}
			}
		}
	}
}
