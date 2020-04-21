package chap09.lecture.localClass;

public class Outter {
	// Local 클래스는 내부에서만 쓰일 수 있고, Object는 모든 자바 클래스의 최상단 클래스이기 때문에
	// 자동형변환을 통해 Object로 리턴 받을 수 있다.
	Object method(final int param) {
		// 로컬 클래스에서 사용하는 메소드의 지역변수는 꼭 final이어야 한다.
		// 필드 값, 파라미터 값을 박제해놓았다. 묵시적으로 final이 됨
		final int localVar = 3;
		class Local {
		int i = localVar;
		int p = param;
		}
		
		Local l = new Local();
		
		return l;
	}
}
