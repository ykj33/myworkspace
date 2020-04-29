package prac.kr.co.ca;

public class MethodEx {
	private static int b = 0;

	public static void z1(int a) {
		System.out.println(a);
	}

	public static void w1(int b) {
		MethodEx.b = b;
	}

	//
//	public static void k3() {
//		System.out.println("a");
//		System.out.println("b");
//	}
//
//	public static void me1() {
//		System.out.println("hello");
//		k3();
//		System.out.println("good");
//	}

	public static void main(String[] args) {
//		System.out.println(1);
//		System.out.println(2);
//		me1();
//		System.out.println(3);
//		System.out.println(4);
		w1(8);
		
		int what = -1;
		z1(what);
	}
}
