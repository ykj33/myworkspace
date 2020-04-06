package chap06.lecture.myclass;

public class MyApp {
	public static void main(String[] args) {
		// stack에 참조변수 c1생성
		MyClass c1;
		// heap에 객체(instance)를 생성하고 참조변수 c1에 할당
		c1 = new MyClass();
		
		//새로운 객체 생성 후 참조변수 c2에 할당
		MyClass c2 = new MyClass();
		
		System.out.println(c1 == c2);
		
//		System.out.println(c1.field1);
//		System.out.println(c1.method1());
	}
}
