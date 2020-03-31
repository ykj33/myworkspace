package chap03.binary.arithmetic;

public class Arithmetic {
	public static void main(String[] args) {
		// + - * / %
		// 정수(byte, short, char, int) -> 결과가 모두 int
		// 두 항의 타입이 다를 경우 큰 타입으로 결과가 나옴

		int i1 = 10;
		int i2 = 20;
		int i3 = i1 + i2;
		int i4 = i1 - i2;
		int i5 = i1 * i2;
		int i6 = i1 / i2; // 결과는 0
		int i7 = i1 % i2; // 10

		byte b1 = 10;
		byte b2 = 20;
//	byte b3 = b1 + b2; // int로 값을 받아야 함
		
		int i8 = 30;
		long l1 = 100000;
		long i9 = i8 + l1;
		
		long l2 = 20000000;
		float f1 = 3.14F;
		float l3 = l2 + f1;
		
		float f2 = 3.14F;
		double d1 = 2.22;
		double f3 = f2 + d1;
		
		char c1 = 'A';
		char c2 = (char) (c1 + 1); // 변수를 사용하여 계산하면 c2는 int로 변환되기 때문에 컴파일 에러, char로 변환해주어야 함
		
	}
}
