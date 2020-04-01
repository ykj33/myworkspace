package chap03.binary.bitwise;

public class Bitwise {
	public static void main(String[] args) {
		// (이항연산자) &, |, ^, (단항연산자) ~

		// & (둘 다 1일 경우만 1, 나머지는 모두 0)
		int a = 45; // 00101101
		int b = 25; // 00011001

		int c = (a & b); // 00001001 // 각 자리수대로 비교 // 9

		System.out.println(c);

		// | (둘 다 0일 경우만 0, 나머지 모두 1)
		c = a | b; // 11110111 // 각 자리수대로 비교 // 61
		System.out.println(c);

		// ^ (둘이 다르면 1, 같으면 0)
		c = a ^ b; // 00110100 // 각 자리수대로 비교 // 52
		System.out.println(c);

		// ~ (비트를 반대로 변경)
		c = ~a; // 00101101 -> 11010010
		System.out.println(c);

		// 쉬프트연산자 >>, <<, >>>

		// << (모든 비트를 왼쪽으로 n칸씩 이동, 1칸씩 이동할 때마다 *2의 결과)
		a = 1;
		c = a << 1; // 비트를 모두 왼쪽으로 1칸씩 이동 후 뒤쪽에 생긴 공백은 0으로, 앞으로 넘어간 것은 삭제
		System.out.println(c);
		c = a << 3;
		System.out.println(c);

		a = -8;
		c = a << 3;
		System.out.println(c);

		// >> (모든 비트를 오른쪽으로 n칸씩 이동, 1칸씩 이동할 때마다 /2의 결과) 이동 후 남은 공백을 채우는 비트가 부호비트
		a = 16;
		c = a >> 3;
		System.out.println(c);

		// >>> (모든 비트를 오른쪽으로 n칸씩 이동) 이동 후 남은 공백을 채우는 비트가 0
		a = -8;
		c = a >>> 1;
		System.out.println(c);
	}
}
