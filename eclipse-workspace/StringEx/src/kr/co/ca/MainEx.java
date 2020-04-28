package kr.co.ca;

import java.util.UUID;

import com.naver.Dog;
import com.naver.Test;

public class MainEx {
	public static void main(String[] args) {
		Dog d1 = new Dog("d001", "happy", "hong");
		Dog d2 = new Dog("d002", "happy", "hong");
		Dog d3 = new Dog("d002", "world", "kim");

		System.out.println(d1.equals(d3)); // false
		System.out.println(d2.equals(d3)); // true

		System.out.println("===============================================");
		Test t = new Test();
		t.me1(); // false

		Test t2 = new Test();
		// 반환형이 있는 메소드는 꼭 변수에 값을 넣어 출력해야 한다.
		boolean b = t2.me2();
		System.out.println(b); // true

		t2.me3(); // false
		t2.me4(); // false, true
		t2.me5(); // true, false

		t2.me61();
//		t2.me7();
		char c2 = t2.me8();
		System.out.println(c2);
		t2.me81("hello", 0);
		t2.me13();
		t2.me14();

		// UUID를 통해 랜덤한 파일명 생성
		// 시스템적으로 유니크한 값을 만들어줄 필요가 있음. 중복을 방지할 수 있음
		UUID uid = UUID.randomUUID();
		String org = "hello.png";
		// toString으로 String으로 값을 리턴받고 org를 추가
		String filename = uid.toString() + "_" + org;
		System.out.println(filename);
		// 만들어놓은 me142()메소드를 통해 원하는 값 출력
		String name = t2.me142(filename);
		System.out.println(name);

		t2.me143();
		t2.me15();
		System.out.println();
		t2.me16(7);
		t2.me17(2, 7);
		System.out.println("=========================");
		t2.me182();
		t2.me183();
	}
}
