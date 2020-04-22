package chap10.lecture.throwKeyword;

public class ThrowSample {
	public static void main(String[] args) throws Exception {

		if (args.length < 1) {
			// String 파라미터 값이 에러 메시지가 됨
			throw new Exception("배열의 길이가 부족합니다.");
		}
	}
}
