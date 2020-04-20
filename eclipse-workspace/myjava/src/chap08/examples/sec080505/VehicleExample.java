package chap08.examples.sec080505;

public class VehicleExample {
	public static void main(String[] args) {
//		Vehicle vehicle = new Bus();
		Vehicle vehicle = new Taxi();

		vehicle.run();
		// vehicle checkFare(); // vehicle인터페이스에는 checkFare()가 없음

		System.out.println(vehicle instanceof Bus); // false
		System.out.println(vehicle instanceof Taxi); // true
		System.out.println(vehicle instanceof Vehicle); // true

		if (vehicle instanceof Bus) {
			Bus bus = (Bus) vehicle;
			bus.run();
			bus.checkFare();
		}
	}
}
