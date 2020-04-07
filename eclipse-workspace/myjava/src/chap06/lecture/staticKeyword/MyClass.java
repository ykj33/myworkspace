package chap06.lecture.staticKeyword;

public class MyClass {
	static int j; // static field, class field

	int i; // instance field
	
	static {
		j = 98765;
	}
	
	MyClass() {
		//인스턴스 초기화하는 코드들 작성.
	}

	void method() {
		System.out.println(this.i);
		System.out.println("인스턴스 메소드");
	}

//static method, class method
	static void method2() {
		// this 사용 불가, 모든 인스턴스가 공유하기 때문에 this를 지칭할 수 없음
//		method();
//		System.out.println(i); // 스태틱 멤버에서는 인스턴스 멤버로 접근 불가
//		System.out.println(this.j);
		System.out.println("스태틱 메소드");
	}
}
