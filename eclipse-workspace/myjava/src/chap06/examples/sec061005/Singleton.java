package chap06.examples.sec061005;

public class Singleton {
	// private은 클래스 안에서만 접근이 가능하다.
	// private을 통해 클래스 필드에 접근 불가
	private static Singleton singleton = new Singleton();

	// private을 통해 생성자를 사용할 수 없도록 한다.
	private Singleton() {
	}

	// 생성자를 사용할수도, 객체에 접근할 수도 없게 만든 뒤 메소드로만 접근할 수 있게 한다.
	static Singleton getInstance() {
		return singleton;
	}
}
