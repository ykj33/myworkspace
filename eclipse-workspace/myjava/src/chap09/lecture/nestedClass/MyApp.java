package chap09.lecture.nestedClass;

public class MyApp {
	public static void main(String[] args) {
		NestedClass.staticM = 3;
		NestedClass n = new NestedClass();
		n.instanceM = 3;
		
		// 스태틱은 클래스이름으로 바로 접근 가능
		NestedClass.StaticClass ns = new NestedClass.StaticClass();
//		NestedClass.OtherClass no = new NestedClass.OtherClass();
		
		// 인스턴스 클래스는 외부 객체 생성 후 생성 가능
		NestedClass nc = new NestedClass();
		NestedClass.OtherClass no = nc.new OtherClass();
	}
}
