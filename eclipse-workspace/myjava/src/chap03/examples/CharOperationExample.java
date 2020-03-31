package chap03.examples;

public class CharOperationExample {
	public static void main(String[] args) {
		char c1 = 'A' + 1;
		char c2 = 'A';
		// char c3 = c2 + 1; // 컴파일 에러
		System.out.println("c1 : " + c1);
		System.out.println("c2 : " + c2);
		// System.out.println("c3 : " + c3); // char를 변수에 저장해 놓고 int와 계산하게 되면 컴파일 에러가 나게 된다.
	}
}
