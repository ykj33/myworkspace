package chap11.examples.sec110302;

import java.util.HashMap;

public class KeyExample {
	public static void main(String[] args) {
		// Key 객체를 식별키로 사용해서 String 값을 저장하는 HashMap 객체 생성
		HashMap<Key, String> hasMap = new HashMap<Key, String>();

		// 식별키 "new Key(1)"로 "홍길동"을 저장함
		hasMap.put(new Key(1), "홍길동");

		// 식별키 "new Key(1)"로 "홍길동"을 불러옴
		String value = hasMap.get(new Key(1));
		// number로 필드값을 저장했어도 hashcode를 재정의하지 않았기에 참조값을 불러와 식별키가 작동하지 않음
		System.out.println(value);
	}
}
