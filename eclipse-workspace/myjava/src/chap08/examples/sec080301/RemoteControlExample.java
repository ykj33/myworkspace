package chap08.examples.sec080301;

import chap08.examples.sec080201.RemoteControl;

public class RemoteControlExample {
	public static void main(String[] args) {
		RemoteControl rc;
		rc = new Television();
		rc = new Audio();

		rc.turnOn();
		rc.turnOff();
		rc.setVolume(3);

		// 인터페이스로는 인스턴스를 만들 수 없다.
		// 몸통을 붙여서 여기서 클래스를 정의하면 일회성으로 사용 가능 - 익명구현 객체
		RemoteControl r1 = new RemoteControl() {

			@Override
			public void turnOn() {
				// TODO Auto-generated method stub

			}

			@Override
			public void turnOff() {
				// TODO Auto-generated method stub

			}

			@Override
			public void setVolume(int volume) {
				// TODO Auto-generated method stub

			}

		};
	}
}
