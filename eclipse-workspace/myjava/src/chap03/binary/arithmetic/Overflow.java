package chap03.binary.arithmetic;

public class Overflow {
	public static void main(String[] args) {
		int i1 = 20_0000_0000;
		int i2 = 10_0000_0000;

		int avg = (i1 + i2) / 2; // 더하는 순간 int가 표현할 수 있는 값을 넘어서 overflow가 일어남
		System.out.println(avg);
		
		long l1 = 20_0000_0000;
		long l2 = 10_0000_0000;

		long avg2 = (l1 + l2) / 2; //
		System.out.println(avg2);


	}
}
