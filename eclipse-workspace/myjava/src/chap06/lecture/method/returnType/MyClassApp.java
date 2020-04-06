package chap06.lecture.method.returnType;

public class MyClassApp {
	public static void main(String[] args) {

		MyClass c1 = new MyClass();
		c1.method2(3);
		c1.method2(2);
		int c = c1.method3();
		System.out.println(c);
		System.out.println(c1.method3());

//		int d = c1.method4(9); // long으로 반환되어서 int에 할당 불가
		long d = c1.method4(9);
		System.out.println(d);
		System.out.println(c1.method4(5));
	}
}
