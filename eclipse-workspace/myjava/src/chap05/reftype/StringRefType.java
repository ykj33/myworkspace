package chap05.reftype;

public class StringRefType {
	public static void main(String[] args) {
		// 05. String

		String a = new String("java");
		String b = new String("java");

		System.out.println(a == b);
		System.out.println(a.equals(b)); // 값을 비교

		// String은 new를 생략해도 가능
		String c = "java";
		System.out.println(a == c);
		System.out.println(b == c);
		System.out.println(a.equals(c));
		System.out.println(b.equals(c));

		// 이미 literal한 값이 존재하면 새로운 객체를 생성하지 않고 이미 있는 객체를 참조함
		String d = "java";
		System.out.println(c == d); // true
		System.out.println(c.equals(d)); // true
	}
}
