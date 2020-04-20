package chap08.lecture.casting;

public class MyApp {
	public static void main(String[] args) {
		Pet p1 = new Dog();
		Pet p2 = new Cat();

		p1.sit();
		p2.sit();

		// 강제 형변환 가능
		Dog d = (Dog) p1;
		d.bark();
		d.sit();
	}
}
