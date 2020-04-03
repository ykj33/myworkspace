package chap05.array;

public class CopyUtil {
	public static void main(String[] args) {
		int[] a = { 9, 8, 7 };
		int[] b = new int[5];

		// System.arraycopy(원본, 원본의 시작 위치, 대상, 대상의 시작 위치, 복사할 개수);
		System.arraycopy(a, 1, b, 2, 2);
		
		for (int v : b) {
			System.out.println(v);
		}
	}
}
