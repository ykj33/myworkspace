package chap11.examples.sec110601;

class Car {

}

public class ClassExample {
	public static void main(String[] args) {
		// 인스턴스 생성으로 class 정보 얻기
		Car car = new Car();
		Class clazz1 = car.getClass();
		System.out.println(clazz1.getName());
		System.out.println(clazz1.getSimpleName());
		System.out.println(clazz1.getPackage().getName());
		System.out.println();

		// static 클래스로 class 정보 얻기
		try {
			Class clazz2 = Class.forName("chap11.examples.sec110601.Car");
			System.out.println(clazz2.getName());
			System.out.println(clazz2.getSimpleName());
			System.out.println(clazz2.getPackage().getName());
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	
		// class 필드로 클래스 정보 얻기
		System.out.println();
		Class clazz3 = Car.class;
		System.out.println(clazz3.getName());
		System.out.println(clazz3.getSimpleName());
		System.out.println(clazz3.getPackage().getName());
	
	
	}
}
