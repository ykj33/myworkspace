package chap06.examples.sec061302.package1;

public class A {
// 필드
	A a1 = new A(true); // o
	A a2 = new A(1); // o
	A a3 = new A("문자열"); // o

	// 생성자
	public A(boolean b) { // public 접근 제한

	}

	A(int b) { // default 접근 제한

	}

	private A(String s) { // private 접근 제한

	}
}
