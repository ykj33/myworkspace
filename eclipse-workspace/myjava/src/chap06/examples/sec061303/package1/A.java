package chap06.examples.sec061303.package1;

public class A {
// 필드
	public int field1;
	int field2;
	private int field3;

	// 생성자
	public A() {
//		클래스 내부일 경우 접근 제한자의 영향 X
		field1 = 1;
		field2 = 1;
		field3 = 1;

		method1();
		method2();
		method3();
	}

	// 메소드
	public void method1() {

	};

	void method2() {

	};

	private void method3() {
	};
}
