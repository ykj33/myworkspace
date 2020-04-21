package chap09.lecture.anonymous;

public class MyApp {
	public static void main(String[] args) {
		Parent p1 = new Parent();
		Parent p2 = new Child();
		// 클래스 생성과 정의를 한번에 할 수 있음, 익명 객체
		Parent p3 = new Parent() {
			@Override
			void method() {
				System.out.println("anonymous method");
			}
		};
		p1.method();
		p2.method();
		p3.method();
	}
}
