package chap06.lecture.constructor;

public class MyDefaultConstructorApp {
public static void main(String[] args) {
	// 파라미터가 있는 생성자가 생성되었으므로, 파라미터가 없는 기본 생성자가 생성되지 않는다.
	DefaultConstructor d1 = new DefaultConstructor();
	
	DefaultConstructor d2 = new DefaultConstructor(2);
}
}
