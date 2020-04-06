package chap06.lecture.method.parameter;

public class Method2App {
	public static void main(String[] args) {
		Method2 m1 = new Method2();
		m1.method1();
		m1.method2(3);
		m1.triple(9);
		m1.plus(9, 10); // 넣어준 값은 argument, 인자
		m1.triple2(3.14);
		m1.triple2(3); //double이 아닌 int를 넣어주어도 작동, 자동형변환되기 때문
		m1.max(1,2,3,454,5,6,7,8,9,0);
		m1.max(new int[] {6,7,8}); // 실제 배열을 넣어주어도 됨
	}
}
