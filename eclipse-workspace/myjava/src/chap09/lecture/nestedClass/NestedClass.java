package chap09.lecture.nestedClass;

public class NestedClass {
	static int staticM; // 객체 생성없이 가능
	int instanceM; // 객체 생성해야 함

	// 스태틱 클래스
	static class StaticClass {
		int field;
		static int staticField;
	}

	// 인스턴스 클래스, 논 스태틱 클래스
	class OtherClass {
		int field;
		// 인스턴스 클래스 내부엔 스태틱 멤버 X
//		static int staticField;

		OtherClass() {

		}

		void method() {

		}

	}

	void method() {
		class LocalClass {
			int field;
			// 로컬 클래스 내부엔 스태틱 멤버 X
//			static int staticField;
		}
		// 메소드 내의 클래스는 메소드 내에서만 객체 생성 가능
		LocalClass lc = new LocalClass();
	}
}
