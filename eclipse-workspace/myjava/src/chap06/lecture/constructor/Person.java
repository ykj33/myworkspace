package chap06.lecture.constructor;

public class Person {
	String name;
	int age;

	// 객체 생성 시 필드의 값을 초기화하고, 전달받은 값을 필드의 값으로 할당한다.
	//this는 자기 자신(앞으로 만들어질 인스턴스)을 뜻함, 같은 this라고 하더라도 만들어진 다음에야 무엇을 지칭하는지 알 수 있음
	// this로 지칭하는 것은 필드, 쉽게 말해 파라미터로 받은 값을 필드에 할당하겠다는 뜻
	Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println(this.name);
		System.out.println(this.age);
	}
}
