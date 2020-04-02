package chap04.breakContinue;

public class BreakContinue {
	public static void main(String[] args) {
		// break;
		for (int j = 0; j < 5; j++) { // 라벨을 달아주면 해당 라벨의 loop가 종료됨, 권
			System.out.println("j : " + j);
			for (int i = 0; i < 5; i++) {
				System.out.println("i : " + i);
				if (i == 2) {
					break;
				}
			}
		}

		// continue;
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			if (i == 2) {
				continue;
			}
			System.out.println("continue 이후 실행문");
		}

	}
}
