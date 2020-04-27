package com.naver;

import kr.co.ca.Person;

public class MainEx {
	public static void main(String[] args) {
		// 런타임 중 발생하는 예외
//		int b = 4 / 0;
		// 컴파일 중 발생하는 예외
//		Cat[] a =new Cat();

		Cat c1 = new Cat();
		Cat c2 = new Cat();
		Cat c3 = new Cat(2300, new String("world"));
		// 특별한 의미가 있는 것이 아닌 Cat타입의 배열 생성
		Cat[] cArr = { c1, c3 };
		Person hong = new Person("33", "홍길동", cArr);
		// 먼저 변수에 배열을 넣고
		Cat[] arr = hong.getcArr();
		Cat who = arr[1];
		String name = who.getName();
		// 배열을 출력
		System.out.println(name);

		System.out.println("hello");
		System.out.println("hi");
		System.out.println("hello");
		System.out.println("hi");
		System.out.println("good");
		System.out.println("hi");
		System.out.println("hello1");
		System.out.println("hi");
		
		
		// 다형성 때문에 가능함
		Fruit[] fArr = {new Apple(), new Banana(), new Pear()};
		
		Fruit f = fArr[0];
		
		FruitSeller jangsu = new FruitSeller(fArr);

	}
}
