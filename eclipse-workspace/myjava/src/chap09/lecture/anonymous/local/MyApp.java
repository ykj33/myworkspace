package chap09.lecture.anonymous.local;

import chap09.lecture.anonymous.MyInterface;

public class MyApp {
	public static void main(String[] args) {
		int localVar = 3;
		class Local {
			void method() {
				System.out.println(localVar);
			}
		}
		Local l = new Local();

		// 로컬 클래스를 만들어 인스턴스까지 만드는 것을 한번에
		// 로컬 변수는 늘 final

		MyInterface mi = new MyInterface() {
			@Override
			public void method() {
				System.out.println("구현된 메소드");
				System.out.println(localVar);

			}
		};
	}

}
