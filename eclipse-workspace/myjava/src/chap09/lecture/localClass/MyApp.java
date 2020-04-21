package chap09.lecture.localClass;

public class MyApp {
	public static void main(String[] args) {
		Outter o = new Outter();
		// Object 타입에 자동형변환이 되어 들어간다.
		Object l = o.method(5);
		// 메소드가 끝났음에도 객체를 계속 사용할 수 있음
		System.out.println(l);
	}
}
