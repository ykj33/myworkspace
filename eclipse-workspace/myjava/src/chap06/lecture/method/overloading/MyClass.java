package chap06.lecture.method.overloading;

public class MyClass {
	// Method Overloading
	// 메소드의 이름이 같다.
	// 파라미터의 타입, 순서, 개수가 다르다.
	// 리턴타입은 상관없다.

	void method() {
		System.out.println("파라미터없는 메소드");
	}

	int method(int i) {
		System.out.println("int타입하나 받는 메소드");
		return 1;

	}

	void method(int i, int j) {
		System.out.println("int타입 2개 받는 메소드");
	}

	void method(long i) {
		System.out.println("long타입 하나 받는 메소드");
	}

	void method(int i, long j) {
		System.out.println("int, long 받는 메소드");
	}

	void method(long i, int j) {
		System.out.println("long, int 받는 메소드");
	}
}
