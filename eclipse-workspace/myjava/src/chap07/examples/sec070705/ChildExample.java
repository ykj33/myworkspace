package chap07.examples.sec070705;

public class ChildExample {
// 강제 타입 변환
	public static void main(String[] args) {
		Parent parent = new Child();
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		/*
		 * 불가능 parent.field2 = "data2";
		 *  parent.method3();
		 */

		Child child = (Child) parent;
		child.field2 = "yyy"; // 가능
		child.method3(); // 가능
	}
}
