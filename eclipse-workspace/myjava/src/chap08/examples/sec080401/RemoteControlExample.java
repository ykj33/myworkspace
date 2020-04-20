package chap08.examples.sec080401;

import chap08.examples.sec080201.RemoteControl;
import chap08.examples.sec080301.Audio;
import chap08.examples.sec080301.Television;

public class RemoteControlExample {
	public static void main(String[] args) {
		RemoteControl rc = null;

		// 다형성
		rc = new Television();
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(3);
		rc.setMute(false);

		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(6);
		rc.setMute(true);
		
		// static 메소드이기 때문에 인터페이스명 만으로도 사용 가능
		RemoteControl.changeBattery();
	}
}
