package chap07.examples.sec070701;

public class ChildExample {
	public static void main(String[] args) {
		// 그림 11. 다형성 예제1
		Child child = new Child();

		// 자동 타입 변환
		// child객체의 참조값을 parent 참조 변수에 할당
		Parent parent = child;
		// p참조변수에 Parent 객체 할당
		Parent p = new Parent();
		// p에 다시 child객체 참조값 할당. Parent객체는 garbage값이 됨
		p = child;
		parent.method1();
		// 재정의된 메소드가 호출됨
		parent.method2();
		// parent.method3(); 호출 불가능 타입이 Parent, Parent에는 method3()이 없다.
	}
}
