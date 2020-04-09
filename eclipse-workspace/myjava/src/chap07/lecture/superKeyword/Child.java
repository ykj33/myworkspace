package chap07.lecture.superKeyword;

public class Child extends Parent {
	public int j;

	@Override
	public void method() {
		// 이미 있는 부모 메소드를 호출하여 전체를 덮어쓰는 것이 아니라 추가할 수 있게 함 
		super.method();
		System.out.println("재정의된 자식 클래스 메소드");
	}

	void method2() {
		System.out.println("자식 클래스 메소드2");
		// 부모의 필드, 부모의 메소드 접근
		System.out.println(super.i);
		super.method();

		System.out.println(this.i);
		this.method3();
	}

	public void method3() {

	}
}
