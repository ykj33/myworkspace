package chap07.lecture.polymorphism.abstractKeyword;

public class AbstractApp {
	public static void main(String[] args) {
//		추상 클래스이므로 객체 생성 X
//		KindaCat k1 = new KindaCat();
//		k1.cry();

		KindaCat k2 = new Tiger();
		// 상속받은 메소드에 상관없이 추상메소드는 꼭 구현되어야 한다.
		k2.cry();

		Tiger t = new Tiger();
		Cat c = new Cat();
		t.cry();
		c.cry();
	}
}
