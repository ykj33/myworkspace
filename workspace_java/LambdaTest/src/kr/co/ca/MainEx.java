package kr.co.ca;

import com.naver.Cat;
import com.naver.CatImpl;
import com.naver.Dog;
import com.naver.Turtle;
import com.naver.TurtleImpl;

public class MainEx {

	public static void main(String[] args) {

		Turtle t = (String str, int c) -> {
			for (int i = 0; i < c; i++) {
				System.out.println(str);
			}
		};
		t.me3("t", 10);
		Turtle t2 = new TurtleImpl();
		t2.me3("t2", 10);

		Turtle t1 = new Turtle() {
			@Override
			public void me3(String str, int c) {
				System.out.println("t1");
			}
		};
		t1.me3("10", 1);

		System.out.println(":::::::::::::::::::::::::::");

		Cat c = (int a) -> {
			System.out.println("Cat lambda");
		};
		c.me2(10);

		Cat c2 = new CatImpl();
		c2.me2(5);

		// 기존의 방법, 옳지 않은 객체 생성법
		Cat c1 = new Cat() {

			@Override
			public void me2(int a) {
				System.out.println("Cat");
			}
		};

		c1.me2(10);

		// Dog 인터페이스에 있는 me1 메소드를 어떻게 오버라이딩하겠다.
		// 람다식 사용방법
		Dog d = () -> {
			System.out.println("Dog 인터페이스의 me1()메소드 오버라이딩");
		};
		d.me1();

		System.out.println(":::::::::::::::::::::::");

		// 로컬 내부클래스
		class DogImpl implements Dog {

			@Override
			public void me1() {
				// TODO Auto-generated method stub

			}

		}

		Dog d2 = new DogImpl();
		d2.me1();

		Dog d1 = new Dog() {

			@Override
			public void me1() {
				System.out.println("d1");
			}
		};

	}

}
