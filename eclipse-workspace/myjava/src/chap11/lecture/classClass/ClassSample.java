package chap11.lecture.classClass;

class MyClass {
	
}



public class ClassSample {
	public static void main(String[] args) throws Exception {
		MyClass o1 = new MyClass();
		// 인스턴스 생성을 통한 클래스 객체 얻어내기
		Class c1 = o1.getClass();
		
		System.out.println(c1.getName());
		System.out.println(c1.getSimpleName());
		System.out.println(c1.getPackage().getName());
		
		// static으로 클래스 객체 얻어내기
		Class c2 = Class.forName("chap11.lecture.classClass.MyClass");
		System.out.println(c2.getName());
		System.out.println(c2.getSimpleName());
		System.out.println(c2.getPackage().getName());
		System.out.println();
		
		// class는 키워드가 아니라 필드
		Class c3 = MyClass.class;
		System.out.println(c3.getName());
		System.out.println(c3.getSimpleName());
		System.out.println(c3.getPackage().getName());
	}
}
