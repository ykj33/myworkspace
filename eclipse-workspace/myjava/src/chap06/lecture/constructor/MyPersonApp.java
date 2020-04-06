package chap06.lecture.constructor;

public class MyPersonApp {
	// 그림 : 08. this와 instance
	public static void main(String[] args) {
		// 생성자는 주로 이렇게 필드의 값을 초기화하는 역할을 한다.
		Person p1 = new Person("아이언맨", 40);
//		System.out.println(p1.name);
//		System.out.println(p1.age);

		Person p2 = new Person("블랙팬서", 50);
//		System.out.println(p2.name);
//		System.out.println(p2.age);
//		p2.name = "블랙위도우";
//		System.out.println(p2.name);
	}
}
