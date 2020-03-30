package chap03.examples;

public class IncreaseDecreaseOperatorExample {
	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		int z;

		System.out.println("-----------------");
		x++;
		++x;
		System.out.println("x = " + x);

		System.out.println("-----------------");
		y--;
		--y;
		System.out.println("y = " + y);

		System.out.println("-----------------");
		z = x++; // 먼저 z에 x값을 할당
		System.out.println("z = " + z);
		System.out.println("x = " + x);

		System.out.println("-----------------");
		z = ++x; // x를 더하고 z에 할당
		System.out.println("z = " + z);
		System.out.println("x = " + x);

		System.out.println("-----------------");

		z = ++x + y++;
		System.out.println("z = " + z);
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}
}
