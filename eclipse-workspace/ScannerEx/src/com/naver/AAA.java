package com.naver;

import java.util.Scanner;

public class AAA {

	public void me1(Scanner sc) {
		System.out.println("주소를 입력하세요.");
		String msg = sc.nextLine();
		System.out.println(msg);
//		sc.close(); // 외부에서 넘겨받았는데 의도적으로 삭제하면 안된다.
	}

	public void me1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("주소를 입력하세요");
		String msg = sc.nextLine();
		System.out.println(msg);
		sc.close();
	}
}
