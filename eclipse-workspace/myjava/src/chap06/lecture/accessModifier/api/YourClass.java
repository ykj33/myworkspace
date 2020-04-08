package chap06.lecture.accessModifier.api;

public class YourClass {
	MyClass m = new MyClass();

	public int i;
	int j;
	private int k;

	void method() {
		// 내부에서도 접근 가능
		this.i = 3;
		this.j = 4;
		// private은 같은 클래스 내에서만 가능
		this.k = 5;
	}
}
