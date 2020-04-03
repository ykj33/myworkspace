package chap05.array.multi;

public class TwoDArray {
	public static void main(String[] args) {
		// 그림 : 06. 2차원 배열
		int[] a1 = { 1, 2, 3 };
		int[] a2 = { 4, 5, 6 };

		int[][] a3 = { { 1, 2 }, { 3, 4 } };

		System.out.println(a1[2]);
		System.out.println(a3[0][1]); // 2
		System.out.println(a3[1][1]); // 4

		// 공간만 마련
		int[] a4 = new int[3];
		int[][] a5 = new int[3][4]; // 원소가 총 3개, 각 원소는 아이템을 4개씩 가지고 있음
		// {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}
		a5[2][3] = 99;

		for (int i = 0; i < a5.length; i++) {
			for (int j = 0; j < a5[i].length; j++) {
				System.out.println(i + ", " + j + " : " + a5[i][j]);
			}
		}

		//
		int[][] a6 = new int[2][];
		// {null, null};
		System.out.println(a6[0]);
		System.out.println(a6[1]);

		// 나중에 배열에 추가도 가능, 원소마다 아이템의 개수가 다를 수 있다.
		a6[0] = new int[] { 3, 4};
		a6[1] = new int[] { 99, 100, 101, 102 };

		for (int i = 0; i < a6.length; i++) {
			for (int j = 0; j < a6[i].length; j++) {
				System.out.println("[" + i + ", " + j + "] : " + a6[i][j]);
			}
		}
	}
}
