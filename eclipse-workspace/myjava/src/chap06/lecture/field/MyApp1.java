package chap06.lecture.field;

public class MyApp1 {
	public static void main(String[] args) {
		MyField f1 = new MyField();

		// 속성에 값을 할당해줄 수 있다.
		// 이젠 참조변수를 그냥 객체라고 표현할 것

		f1.a = 30;
		f1.n = "값";
		f1.d = 3.14;
		f1.b = false;
		System.out.println(f1.a);
		System.out.println(f1.n);
		System.out.println(f1.d);
		System.out.println(f1.b);

		// 새로 생성된 객체이므로 서로 영향을 미치지 않는다.
		MyField f2 = new MyField();
		System.out.println(f2.a);
		System.out.println(f2.n);
		System.out.println(f2.b);
		
		f2.a = 99;
		
		// 필드는 필드이나, 각 인스턴스가 가지고 있기 때문에 인스턴스 필드라고 함
		// 보통 필드라고 하면 인스턴스 필드를 지칭
		System.out.println(f2.a);
		System.out.println(f1.a);
	}
}
