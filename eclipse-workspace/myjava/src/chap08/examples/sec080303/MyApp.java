package chap08.examples.sec080303;

import chap08.examples.sec080201.RemoteControl;

public class MyApp {
	public static void main(String[] args) {
		// 실제 인스턴스는 3개의 메소드 모두를 가지고 있지만,
		// 어떤 타입으로 선언되느냐에 따라 사용할 수 있는 메소드가 다름
		SmartTelevision st = new SmartTelevision();
		RemoteControl rc = st;
		Searchable sc = st;

		rc.turnOn();
		rc.turnOff();
		rc.setVolume(3);
//	rc.search("네이버");

		sc.search("다음");
//	sc.turnOn();
	}
}
