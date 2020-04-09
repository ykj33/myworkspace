package chap07.lecture.constructor;

public class SubClass extends SuperClass {
	public SubClass() {
//		 상위 클래스의 생성자 호출
		super(3);
		System.out.println();
	}
	
	
}
