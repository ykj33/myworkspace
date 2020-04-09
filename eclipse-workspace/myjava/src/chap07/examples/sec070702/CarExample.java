package chap07.examples.sec070702;

public class CarExample {
	public static void main(String[] args) {
		// Car 객체 생성
		Car car = new Car();
		
		// run()메소드를 5번 실행시켜 switch 값으로 넘겨준다
		for (int i = 1; i <= 5; i++) {
			int problemLocation = car.run();

			// 각 케이스마다 맞는 타이어로 교체
			switch (problemLocation) {
			case 1:
				System.out.println("앞왼쪽 HankookTire로 교체");
				car.frontLeftTire = new HankookTire("앞왼쪽", 15);
				break;
			case 2:
				System.out.println("앞오른쪽 KumhoTire로 교체");
				car.frontRightTire = new KumhoTire("앞오른쪽", 13);
				break;
			case 3:
				System.out.println("뒤왼쪽 HankookTire로 교체");
				car.BackLeftTire = new HankookTire("뒤왼쪽", 14);
				break;
			case 4:
				System.out.println("뒤오른쪽 KumhoTire로 교체");
				car.BackRightTire = new KumhoTire("뒤오른쪽", 17);
				break;
			}
			System.out.println("-------------------------------------");
		}
	}
}
