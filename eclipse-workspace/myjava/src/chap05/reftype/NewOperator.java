package chap05.reftype;

public class NewOperator {
	public static void main(String[] args) {
		// 원래는 new 연산자를 통해 생성하여야 한다.
		// new 연산의 결과는 해당 객체가 생성된 곳의 주소 값
		// 그림 : 02. new 연산자
		String s = new String("java");
		
		Object o = new Object();
		
		String s2 = new String("java");
		
	}
}
