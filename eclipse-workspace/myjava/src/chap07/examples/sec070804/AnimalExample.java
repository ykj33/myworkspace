package chap07.examples.sec070804;

public class AnimalExample {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.sound();
		cat.sound();
		System.out.println("------------");

		// 변수의 자동 타입 변환
		Animal animal = null; // 추상 클래스는 객체를 생성할 수 없기 때문에 null 값으로 참조 변수만 생성
		animal = new Dog(); // 참조 변수에 Dog타입 객체 할당
		animal.sound(); // 메소드 실행
		animal = new Cat();
		animal.sound();
		System.out.println("----------------");

		// 메소드의 다형성
		animalSound(new Dog()); // Animal 타입을 파라미터로 받는 곳에 자식 객체를 대신 넣어 자동으로 형변환
		animalSound(new Cat());

	}

	public static void animalSound(Animal animal) {
		animal.sound();
	}
}
