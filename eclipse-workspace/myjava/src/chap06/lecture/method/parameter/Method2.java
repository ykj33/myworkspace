package chap06.lecture.method.parameter;

public class Method2 {

	void method1() {
		// 파라미터 없음
		System.out.println("파라미터가 없는 메소드");
	}

	void method2(int i) {
		// 파라미터가 int 1개
		System.out.println("파라미터가 int 하나");
	}

	void triple(int i) {
		System.out.println(i * 3);
	}

	void plus(int i, int j) { // parameter, 매개변수, 중괄호 안에서 선언된 것은 중괄호 안에서만
		System.out.println(i + j);
	}

	void triple2(double d) {
		System.out.println(d * 3.0);
	}

	void max2(boolean b, int... n) {// 파라미터 목록 중 앞이나 중간에 들어갈 수 없고 항상 끝에만 들어가야 함

	}

	void max(int... n) { // 파라미터의 개수를 가늠할 수 없을 때 ...으로 사용하고 배열처럼 사용하면 됨

		for (int i = 0; i < n.length; i++) {
			System.out.println(n[i]);
		}

	}
}
