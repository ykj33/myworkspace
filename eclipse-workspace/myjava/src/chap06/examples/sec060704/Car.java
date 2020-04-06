package chap06.examples.sec060704;

public class Car {
// 필드
	// 생성자는 파라미터의 타입의 조합과 순서 따라 다른 생성자로 나뉜다.

	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;

	// 생성자
	Car() {
		System.out.println("에이라는 일을 한다.");
	}

	Car(String model) {
		// 생성자에서 다른 생성자 호출 가능
		this(model, "노랑"); // model과 파라미터로 String을 받는 다른 생성자를 호출한다.
//		this.model = model;
	}

	Car(String model, String color) {
		this();
		this.model = model;
		this.color = color;
	}

	Car(String model, String color, int maxSpeed) {
		this();
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
