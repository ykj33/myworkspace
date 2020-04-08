package chap06.lecture.accessModifier.api;

class MyClass {
	void method() {
		YourClass y = new YourClass();
		// 같은 패키지 안의 다른 클래스에서도 접근 가능
		y.i = 3;
		// default는 같은 패키지 내에선 접근 가능
		y.j = 4;
		// private은 같은 패키지 내에서도 다른 클래스는 불가능
//		y.k = 5;
	}
}
