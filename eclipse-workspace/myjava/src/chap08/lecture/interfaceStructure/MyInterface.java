package chap08.lecture.interfaceStructure;

public interface MyInterface { // 내부의 구성요소는 다 public 
	// 필드 (public static final)
	// 필드를 가질 수 있으나 항상 public static final
	public static final int i = 3;
	int j = 4;

	// 추상메소드 (public abstract)
	int methodName(int i); // abstract가 붙지 않아도 추상메소드

	public abstract int methodName2(); // 항상 public

	// static 메소드 (public)
	// 객체를 생성하지 않아도 사용할 수 있는 메소드
	static void methodName3() {
		System.out.println("스태틱 메소드");
	}

	public static void methodName5() {
		System.out.println("스태틱 메소드");
	}

	// default 메소드 (public)
	// package private과는 다른 default
	default void methodName4() {
		System.out.println("인스턴스 디폴트 메소드");
	}

	public default void methodName6() {
		System.out.println("인스턴스 디폴트 메소드");
	}
}
