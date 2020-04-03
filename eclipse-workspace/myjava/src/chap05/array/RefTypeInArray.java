package chap05.array;

public class RefTypeInArray {
	public static void main(String[] args) {
		int[] a = new int[3];
		a[0] = 3;
		a[1] = 2;
		a[2] = 99;

		String[] sr = new String[3];
		sr[0] = "java";
		sr[1] = "java";
		sr[2] = new String("java");
		System.out.println(sr[0] == sr[1]); // 같은 리터럴
		System.out.println(sr[2] == sr[0]); // 새 객체를 만들었기에 다른 곳 참조

	}
}
