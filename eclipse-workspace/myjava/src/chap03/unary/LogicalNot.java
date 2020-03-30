package chap03.unary;

public class LogicalNot {
	public static void main(String[] args) {
		boolean a = true;

		boolean b = !a; // 연산의 결과가 바뀌는 것일 뿐 해당 값이 바뀌진 않는다.
		System.out.println(b);
		System.out.println(a);

		boolean c = false;
		b = !c;
		System.out.println(b);
		System.out.println(c);

	}
}
