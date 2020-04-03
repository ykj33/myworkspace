package chap05.array.multi;

public class Problem1 {
	public static void main(String[] args) {
		int[][]origin = { { 3, 4, 5 }, { 100, 101 }, { -3, -2, -1, 0 } };
		int[] target = null;
		
		// 선생님의 풀이
		// target 배열의 길이를 얼마나 설정해야 하는지 알아야 한다.
//		int len = 0;
//		for (int i = 0; i<origin.length; i++) {
//			// 각 요소들의 길이를 구해서 더한다.
//			len += origin[i].length;
//		}
////		2차원 배열의 길이를 가진 1차원 배열 생성
//		target = new int[len];
//		//target의 인덱스 번호 변수 생성
//		int k = 0;
//		// 배열을 거꾸로 검색
//		for(int i = origin.length-1; i>=0; i--) {
//			for(int j = origin[i].length-1; j>=0; j--) {
//				System.out.println();
//				//target 배열의 인덱스 번호를 계속 더해가면서 origin 값 추가
//				target[k] = origin[i][j];
//				k++;
//			}
//		}
		
		// {0, -1, -2, -3, 101, 100, 5, 4, 3};
		// target의 길이를 정해야 한다.
		int length =0;
		for (int i = 0; i < origin.length; i++) {
			length += origin[i].length;
		}
		target = new int[length];
		int k = 0;
		for (int i = 2; i >= 0; i--) {
			for (int j = origin[i].length-1; j >= 0; j--) {
//				System.out.println(origin[i][j]);
				// target 배열에 값을 넣어준다.
				target[k] = origin[i][j];
				k++;
			}
		
		}

		for (int i = 0; i < target.length; i++) {
			System.out.println("결과 : "+target[i]);
		}

	}
}
