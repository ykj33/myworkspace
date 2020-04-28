package com.naver;

import java.util.StringTokenizer;

public class Test {

	// 변수 선언 공식
//	자료형 변수명 = 자료형에 맞는 값;
//	char에 숫자를 넣으면 ASCII 코드에 따라 알맞은 알파벳으로 바뀐다.
//	대문자 A(97)는 소문자 A(65)보다 32가 많다.
//	byte : -128 ~ 127
//	int : 21억
//	long은 뒤에 L을 붙여야 한다.
//	float은 뒤에 F 붙여야 한다.

//	자료형 변수명(reference) = new(heap메모리에 새로운 공간을 할당해라) 생성자();
//	String msg1 = "hello"; // 암시적, 묵시적 객체 생성법
//	String msg2 = new String("hello"); // 명시적 객체 생성법

	
	public void me183() {
		String data = "id#age##birth";
		String[] arr1 = data.split("#");
		// split() 메소드는 공백은 구분자 사이의 공백도 인식한다.
		System.out.println(arr1.length);
		StringTokenizer st = new StringTokenizer(data, "#");
		// StringTokenizer는 구분자 사이의 공백은 인식하지 않는다.
		System.out.println(st.countTokens());
		
	}
	
	
	public void me182() {
		String data = "teacehradsflkjar#gpoq#err234#5067";
		// 객체를 생성하듯이 생성하여 나눌 문자열과 토큰을 입력
		StringTokenizer st = new StringTokenizer(data, "#");
		// 배열을 만들고 그 안에 값을 넣어 밖에서도 쓸 수 있게 한다.
		String[] arr = new String[st.countTokens()]; // 배열의 길이는 토큰의 개수만큼
		// 인덱스 번호 미리 생성
		int idx = 0;
		// 토큰이 존재한다면
		while (st.hasMoreTokens()) {
			// 다음 토큰을 출력해라
			String token = st.nextToken();
			System.out.println(token);
			// 배열에 토큰의 값을 넣어줌

			arr[idx++] = token;
		}
		System.out.println(arr[0]);
		System.out.println(arr[1]);

	}

	public void me18() {
		String data = "teacehradsflkjar#gpoq#err234#5067";
		// 괄호 안에 토큰 구분자를 넣는다.
		String[] arr = data.split("#");
		String id = arr[0];
		String age = arr[1];
		String grade = arr[2];
		String point = arr[3];
		System.out.println(id + "님의 남은 포인트는 " + point + "입니다.");
	}

	public void me17(int start, int end) {
		for (int j = start; j < end + 1; j++) {
			me16(j);
		}

	}

	// 2부터 자기 자신-1까지 나누어보는 것으로 소수를 판별할 수 있음
	public void me16(int num) {
		boolean isSosu = true;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				isSosu = false;
				break;
			}
		}
		if (isSosu) {
			System.out.println(num + "은 소수입니다.");
		} else {
			System.out.println(num + "은 소수가 아닙니다.");
		}
	}

	public void me15() {
		for (int i = 0; i < 100; i++) {
			int dap = i / 4;
			System.out.print(dap + ",");
		}
	}

	public void me143() {
		String msg = "hello world good morning";
		String newMsg = msg.substring(6, 16);
		System.out.println(newMsg);
	}

	// me142() 메소드는 파일명을 외부에서입력받아 원래파일명을 반환하는 기능을 가지고 있음.
	// 파일명은 _로 구분됨
	public String me142(String fileName) {
		int idx = fileName.indexOf("_");
		String origin = fileName.substring(idx + 1);
		return origin;
	}

	public void me14() {
		String msg = "xxxxxxxxxx_hello.jpg";
		int idx = msg.indexOf("_");
		String newMsg = msg.substring(idx + 1);
		System.out.println(newMsg);
	}

	public void me13() {
		String msg = "          hello                   world              ";
		String newMsg = msg.trim(); // 원래 문자열과는 상관없이 새로운 String 객체 생성
		System.out.println(msg);
		System.out.println(newMsg);
	}

	public void me12() {
		String msg = "hello";
		int leng = msg.length();
		System.out.println(leng);
		System.out.println(leng - 1); // 문자열의 최대 크기
	}

	public void me112() {
		String msg = "hello.jpg";
		String newMsg = "xxxxxxxxxx_" + msg;
		int idx = newMsg.indexOf("_"); // 을 통해 원하는 곳의 인덱스 번호를 다룰 수 있다.
	}

	public void me11() {
		String msg = "x8jeosz2_emypicture.jpg";
		// 해당 문자열이 몇 번째 인덱스에 있는가.
		int idx = msg.indexOf("_");
		System.out.println(idx);
		idx = msg.indexOf("e");
		System.out.println(idx); // 앞에 있는 문자열부터 접근한다.

		idx = msg.lastIndexOf("e"); // 뒤에 있는 문자열부터 접근한다.
		System.out.println(idx);
		idx = msg.indexOf("e", 5); // 해당 인덱스부터 문자열에 접근해라.
		System.out.println(idx);
	}

	public void me10() {
		String msg = "a.jpg";
		// 해당 문자열로 끝나는가. 특정 확장자를 구분하여야 할 때 필요
		msg.endsWith(".jpg");
	}

	public void me9() {
		String msg = "hello";
		// 포함되어 있는가. 검색 등에 유용하게 사용
		boolean is = msg.contains("l");
		System.out.println(is);

	}

	// me81()메소드는 문자열과 그 문자열의 특정 인덱스를 넘겨받아서
	// 그 인덱스에 해당하는 문자를 출력하는 기능을 가지고 있다.
	public void me81(String msg, int idx) {
		char c = msg.charAt(idx);
		System.out.println(c);
	}

	public char me8() {
		String msg = "hello";

		char c = msg.charAt(0);

		return c;

	}

	// 알고리즘 문제
	public void me7() {
		for (int i = 0; i < 100; i++) {
			int j = i % 4;
			System.out.println(j);
		}
	}

	public void me62(int dan) {
		// StringBuffer를 이용하면 이렇게 사용하여 불변적 성격을 회피할 수 있다.
		for (int i = 1; i < 10; i++) {
			StringBuffer sb = new StringBuffer();
			sb.append(dan);
			sb.append(" x ");
			sb.append(i);
			sb.append(" = ");
			sb.append(dan * i);
			System.out.println(sb.toString());
		}
	}

	public void me61() {
		StringBuffer sb = new StringBuffer();
		sb.append("hello");
		sb.append(" world");
		sb.append(" !!!");

		// 많은 사람들이 StringBuffer를 모르기 때문에 toString으로 바꾸어준다.
		String msg = sb.toString();
		System.out.println(msg);
	}

	public void me6() {
		String msg = "hello";
		msg += " world";
		msg += " !!!";
		System.out.println(msg);
	}

	public void me5() {
		String msg1 = new String("hello");
		String msg2 = new String("hello");
		String msg3 = new String("Hello");

		boolean b = msg1.equals(msg2);
		System.out.println(b);

		System.out.println(msg2.equals(msg3));
	}

	public void me4() {
		String msg1 = new String("hello");
		String msg2 = new String("hello");
		String msg3 = msg2; // msg2에 있던 주소값을 msg3에 할당

		System.out.println(msg1 == msg2);
		System.out.println(msg2 == msg3);
	}

	public void me3() {
		String msg1 = "hello";
		String msg2 = "Hello";
		System.out.println(msg1 == msg2);
	}

	public boolean me2() {
		String msg1 = "hello";
		String msg11 = "hello";

		return msg1 == msg11;
	}

	public void me1() {
		String msg1 = "hello";
		String msg2 = new String("hello");

		// == 동일성 비교는 기본자료형에서만 사용
		System.out.println(msg1 == msg2); // false
	}

}
