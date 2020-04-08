package chap06.lecture.encapsulation;

public class CarApp {
	public static void main(String[] args) {
		Car c = new Car();
//		c.speed = 30;
//		c.speed = -1;
		c.setSpeed(30);
		c.setSpeed(-1);
		
		System.out.println(c.getSpeed());
		System.out.println(c.getAirbag());
	}
}
