package chap09.examples.sec090304;

public class Outter {
	String field = "Outter-field";

	void method() {
		System.out.println("Outter-method");
	}

	class Nested {
		String field = "Nested-field";

		void method() {
			System.out.println("Nested-method");
		}

		void print() {
			// 그냥 this는 자기 자신의 멤버에 접근
			System.out.println(this.field);
			this.method();
			// 바깥 클래스 명을 적어주면 바깥 클래스의 멤버에 접근
			System.out.println(Outter.this.field);
			Outter.this.method();
		}
	}
}
