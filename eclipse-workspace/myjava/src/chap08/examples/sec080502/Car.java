package chap08.examples.sec080502;

public class Car {
	// 인터페이스는 객체를 생성할 수 없으니, Tire 인터페이스를 구현한 한국, 금호타이어로 객체를 생성
	Tire frontLeftTire = new HankookTire();
	Tire frontRightTire = new HankookTire();
	Tire backLeftTire = new HankookTire();
	Tire backRightTire = new HankookTire();

	void run() {
		// 재정의된 인스턴스의 메소드가 실행됨
		frontLeftTire.roll();
		frontRightTire.roll();
		backLeftTire.roll();
		backRightTire.roll();
	}
}
