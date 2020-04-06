package chap06.examples.sec060705;

public class Car {
	// 필드
	// 생성자는 파라미터의 타입의 조합과 순서 따라 다른 생성자로 나뉜다.

	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;

	// 생성자
	Car() {

	}

	Car(String model) {// 3번째 생성자 호출
		this(model, "은색", 250); //
	}

	Car(String model, String color) {// 3번째 생성자 호출
		this(model, color, 250);
	}

	Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
