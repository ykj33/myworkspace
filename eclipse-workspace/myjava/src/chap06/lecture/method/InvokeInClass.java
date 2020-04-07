package chap06.lecture.method;

public class InvokeInClass {
	void method1() {
		System.out.println("method1 실행");

	}
	
	void method2() {
		this.method1(); // 가능은 하다. this는 이 클래스를 통해 만들어지는 인스턴스 그 자체
		System.out.println("method2 실행");
	}
}
