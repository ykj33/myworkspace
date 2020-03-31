package chap03.binary.compare;

public class Compare {
	public static void main(String[] args) {
		// ==, !=, >, >=, <, <=

		int i = 10;
		int j = 15;

		boolean b = i == j;
		System.out.println(b);
		System.out.println(i != j);
		System.out.println(i > j);
		System.out.println(i >= j);
		System.out.println(i < j);
		System.out.println(i <= j);

		// 다른 타입끼리 비교될 때
		// 큰 타입으로 자동 형변환

		System.out.println('A' == 65); // 'A'가 integer로 변경되어 비교
		System.out.println(3 == 3.0); // int가 double로 변경되어 비교
		System.out.println(0.1 == 0.1F); //근사값으로 표현하기 때문에 오류
	}
}
