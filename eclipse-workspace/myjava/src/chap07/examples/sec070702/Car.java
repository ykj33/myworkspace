package chap07.examples.sec070702;

public class Car {
	// 필드
	Tire frontLeftTire = new Tire("앞왼쪽", 6);
	Tire frontRightTire = new Tire("앞오른쪽", 2);
	Tire BackLeftTire = new Tire("뒤왼쪽", 3);
	Tire BackRightTire = new Tire("뒤오른쪽", 4);

	// 생성자

	// 메소드
	// 모든 타이어를 1회 회전시키기 위해 roll() 메소드를 호출
	// false가 있을 경우 stop()메소드를 호출하고 해당 타이어 번호를 리턴
	int run() {
		System.out.println("[자동차가 달립니다.]");
		if (frontLeftTire.roll() == false) {
			stop();
			return 1;

		}
		if (frontRightTire.roll() == false) {
			stop();
			return 2;

		}
		if (BackLeftTire.roll() == false) {
			stop();
			return 3;

		}
		if (BackRightTire.roll() == false) {
			stop();
			return 4;

		}
		return 0;

	}

	void stop() {
		System.out.println("[자동차가 멈춥니다.]");
	}
}
