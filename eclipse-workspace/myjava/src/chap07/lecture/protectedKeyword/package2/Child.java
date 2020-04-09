package chap07.lecture.protectedKeyword.package2;

import chap07.lecture.protectedKeyword.package1.Parent;

public class Child extends Parent {
	void method() {
		// 다른 패키지에 있으므로 접근 불가
//		 this.defaultField = 3;
		// 상속 받았으므로 접근 가능
		this.protectedField = 3;
	}
}
