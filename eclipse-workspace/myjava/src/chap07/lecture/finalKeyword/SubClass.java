package chap07.lecture.finalKeyword;

public class SubClass extends SuperClass {

	@Override
	void superMethod() {
		super.superMethod();
	}

	void method1() {
		final int i = 30;
//		i = 40;
	}
}
