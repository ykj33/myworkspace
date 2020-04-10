package chap07.examples.sec070803;

public class PhoneExample {
	public static void main(String[] args) {
		// Phone phone = new Phone(); // 추상 클래스이기 때문에 인스턴스 생성 X

		SmartPhone smartPhone = new SmartPhone("홍길동"); // 실체 클래스가 인스턴스를 만들어야 함

		smartPhone.turnOn();
		smartPhone.internetSearch();
		smartPhone.turnOff();

		Phone phone = smartPhone;
	}
}
