package chap07.examples.sec070706;

public class InstanceofExample {
// 객체 타입 확인

	public static void method1(Parent parent) {
		if (parent instanceof Child) { // parent 객체가 Child 타입이라면
			Child child = (Child) parent;
			System.out.println("method1 - Child로 변환 성공");
		} else {
			System.out.println("method1 - Child로 변환되지 않음");
		}
	}

	public static void method2(Parent parent) {
		Child child = (Child) parent; // 검수하지 않고 변환하려 할 시 ClassCastException이 발생
		System.out.println("method2 - Child로 변환 성공");
	}

	public static void main(String[] args) {
		Parent parentA = new Child(); // Child 객체를 매개값으로 전달
		method1(parentA);
		method2(parentA);

		Parent parentB = new Parent(); // Parent 타입을 매개값으로 전달
		method1(parentB);
		method2(parentB);
	}
}
