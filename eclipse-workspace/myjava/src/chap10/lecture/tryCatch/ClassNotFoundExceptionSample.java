package chap10.lecture.tryCatch;

public class ClassNotFoundExceptionSample {
	public static void main(String[] args) {
		// forName은 throw로 예외값을 던지므로 꼭 trycatch로 받아줘야 함
		try {
			Class.forName("java.lang.String");
			System.out.println("프로그램 실행중");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾지 못함");
		}
		System.out.println("프로그램 종료");
	}
}
