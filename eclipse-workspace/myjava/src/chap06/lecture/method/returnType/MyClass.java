package chap06.lecture.method.returnType;

public class MyClass {

	// 리턴타입 : 리턴하는 값의 타입
	// void : 리턴하는 값이 없다. 리턴값이 있어도 쓸 수는 있음
	void method1() {
		// return 키워드
		// 1. method를 종료하고
		// 2. 오른쪽에 작성된 값을 호출한 곳으로 반환

		return;
	}

	void method2(int i) {
		if (i % 2 == 0) {
			System.out.println("메소드를 종료합니다.");
			return;
		}

		System.out.println(i * i);
	}

	int method3() {
		return 3;
	}

	long method4(int a) {
		return a * a; // 자동으로 long타입으로 형변환이 되어 에러 X
	}
}
