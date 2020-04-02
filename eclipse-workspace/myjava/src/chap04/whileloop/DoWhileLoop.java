package chap04.whileloop;

public class DoWhileLoop {
	public static void main(String[] args) {
		int i = 0;
		while (i != 0) {
			System.out.println("while 반복");
		}

		do {
			System.out.println("do while 반복");
		} while (i != 0); // 조건의 참, 거짓에 상관없이 무조건 1번은 실행

		System.out.println("end");
	}
}
