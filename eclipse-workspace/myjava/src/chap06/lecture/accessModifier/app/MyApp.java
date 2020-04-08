package chap06.lecture.accessModifier.app;

import chap06.lecture.accessModifier.api.YourClass;

public class MyApp {
	YourClass y = new YourClass();
//	public이 없기 때문에 패키지 밖으로 공개되지 않아 사용할 수 없음
//	chap06.lecture.accessModifier.api.MyClass m;

	void method() {
		// public이기에 다른 패키지에서도 접근 가능
		y.i = 3;
		// default는 다른 패키지 내에서 접근 불가
//		y.j = 4;
		// private은 다른 패키지에서는 당연히 사용 불가
//		y.k = 5;

	}
}
