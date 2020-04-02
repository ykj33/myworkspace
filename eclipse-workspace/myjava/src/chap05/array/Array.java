package chap05.array;

public class Array {
	public static void main(String[] args) {
		int age1;
		int age2;
		int age3;
		;
		;
		;
		int age100;
		int[] ageArray; //주로 이렇게 사용
		int ageArray5[];
		ageArray = new int[100]; // 100개의 공간을 마련한다.

		// 배열의 초기값
		System.out.println(ageArray[22]);

		// 배열의 초기값 할당
		int[] ageArray2;
		ageArray2 = new int[] { 3, 4, 1, 0, -1, 5, 22 };
		System.out.println(ageArray2[0]);
		System.out.println(ageArray2[6]);

		// 선언과 동시에 값을 넣을 땐 new 생략 가능
		int[] ageArray3 = { 9, 10, 11, -9, 33 };
		System.out.println(ageArray3[0]);
		System.out.println(ageArray3[4]);

		// 배열의 인덱스 0~길이-1

		// 배열의 길이
		System.out.println(ageArray.length);
		System.out.println(ageArray2.length);
		System.out.println(ageArray3.length);

		// ArrayIndexOutOfBoundsException 배열의 길이를 넘겼을 때
//		System.out.println(ageArray[100]);

		// 배열과 for
		for (int i = 0; i < ageArray3.length; i++) {
			System.out.println(ageArray3[i]);
		}

		// 배열의 값 변경
		ageArray3[0] = 99999999;
		System.out.println(ageArray3[0]);
		
		// 향상된 for문 좌측엔 값을 받을 변수, 오른쪽은 배열 등 여러값을 가진 객체
		// 오른쪽에서 변수로 차례로 하나씩 값을 순서대로 넣어서 실행함
		for (int value : ageArray3) {
			System.out.println(value);
		}

	}
}
