package chap05.exercises;

public class Exercise08 {
	public static void main(String[] args) {
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };

		int sum = 0;
		double avg = 0.0;

//		for (int i = 0; i<array.length; i++) {
//			for (int j = 0; j<array[i].length; j++) {
//				sum = sum + array[i][j];
//				avg = (double) sum/10;
//	
//			}
//		}
		int cnt = 0;
		for (int[] arr : array) {
			for (int v : arr) {
				sum += v;
				cnt++;
			}
		}
		avg = sum / (double) cnt;
		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);
	}
}
