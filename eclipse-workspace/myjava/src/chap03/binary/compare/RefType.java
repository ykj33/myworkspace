package chap03.binary.compare;

public class RefType {
	public static void main(String[] args) {
		String a = "자바";
		String b = "자바";

		boolean r = a == b; // 같은 내용의 경우 같은 주소를 참조하기에 같다.
		System.out.println(r);

		String c = "자";
		String d = "바";
		String e = c + d; // 내용은 같더라도 주소가 다르기 때문에 다르다.

		System.out.println(b);
		System.out.println(e);

		r = b == e;
		System.out.println(r);
		System.out.println(b.equals(e)); // equals() 메소드를 사용하면 실제 값을 비교할 수 있다.

		String f = new String("자바"); // 새로운 객체가 만들어져 새로운 주소를 가지고 있기에 같지 않다.
		System.out.println(b == f);

		// 실제로 존재하는 곳의 위치, int값으로 받아 출력시킨다.
		int aHashcode = System.identityHashCode(a);
		int bHashcode = System.identityHashCode(b);
		int eHashcode = System.identityHashCode(e);
		int fHashcode = System.identityHashCode(f);

		System.out.println(aHashcode);
		System.out.println(bHashcode);
		System.out.println(eHashcode);
		System.out.println(fHashcode);
		System.out.println();
		// object의 hashcode는 객체의 주소를 기준, String에서 hashcode는 문자열의 내용을 기준, 그래서 같은 "자바"이므로 해쉬코드가 같다.
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(e.hashCode());
		System.out.println(f.hashCode());
		
	}
}
