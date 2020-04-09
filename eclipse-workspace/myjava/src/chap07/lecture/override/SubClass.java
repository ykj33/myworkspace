package chap07.lecture.override;

public class SubClass extends SuperClass {
	// method overriding
	public void method1() {
		System.out.println("서브클래스의 메소드1");

	}

	// 부모 클래스에 파라미터를 받는 메소드가 없으므로 오버라이딩이 아니다.
	public void method1(int i) {
		System.out.println("서브클래스의 메소드1(int)");
	}
}
