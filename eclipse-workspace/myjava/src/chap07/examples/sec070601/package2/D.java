package chap07.examples.sec070601.package2;

import chap07.examples.sec070601.package1.A;

public class D extends A {
	// new 연산자를 사용해서 생성자 직접 호출 불가능, 자식 생성자에서 super로 A 생성자 호출해야 함
	//	A a = new A();
	public D() {
		// 상속받았기에 생성자 생성 시 부모 클래스의 생성자가 먼저 호출 됨
		super(); // o
		// protected이므로 상속 받았을 시 사용 가능
		this.field = "value"; // o
		// protected이므로 상속 받았을 시 사용 가능
		this.method(); // o
	}
}
