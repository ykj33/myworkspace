package chap07.lecture.inheritance;

public class MyApp {
	public static void main(String[] args) {
		// Parent 클래스를 상속받았기에 Parent 클래스의 필드, 메소드 사용 가능
		Child c = new Child();
		c.i = 30;
		c.method();
		
		GrandChild g = new GrandChild();
		g.i = 40;
		g.method();
	}
}
