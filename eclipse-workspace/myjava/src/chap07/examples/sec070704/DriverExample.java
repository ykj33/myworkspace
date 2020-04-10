package chap07.examples.sec070704;

public class DriverExample {
	public static void main(String[] args) {
		Driver driver = new Driver();
		Bus bus = new Bus();
		Taxi taxi = new Taxi();

		driver.drive(bus);
		driver.drive(taxi);
	}

	// Vehicle 타입을 반환해야 하나 하위 클래스를 반환해도 자동변환된다.
	public static Vehicle getVehicle() {
		Taxi t = new Taxi();
		return t;
	}
}
