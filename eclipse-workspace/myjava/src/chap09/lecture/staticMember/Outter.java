package chap09.lecture.staticMember;

public class Outter {
	// 필드이나 타입이 내부 클래스로 만들어진 필드
	NonStatic ns = new NonStatic();
	Static st = new Static();

//	static NonStatic sns = new NonStatic(); // 스태틱에선 인스턴스 멤버에 접근할 수 없음
	static Static nst = new Static();

	int instanceF;
	static int staticF;

	class NonStatic { // 논 스태틱 클래스
		void method() {
			staticF = 5; // 스태틱 멤버 접근 가능
			instanceF = 7; // 인스턴스 멤버 접근 가능
		}
	}

	static class Static { // 스태틱 클래스
		void method() {
			staticF = 9; // 스태틱 멤버 접근 가능
//			instanceF = 99; // 인스턴스 멤버 접근 불가능		
		}
	}

	void instanceMethod() {
		instanceF = 5;
		staticF = 3;
	}

	static void staticMethod() {
//		intstancF = 99; 스태틱 멤버는 인스턴스 멤버에 접근할 수 없음. 어떤 객체의 멤버가 될 지 모르기 때문
		staticF = 9;
	}
}
