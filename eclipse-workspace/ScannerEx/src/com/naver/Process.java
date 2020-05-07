package com.naver;

import java.util.Scanner;

public class Process {
	public Process() {
		String str = new String("hello");
		System.out.println(str);

		System.out.println(":::::::::::::::::::::");

		Scanner sc = new Scanner(System.in); // System.in = 키보드
//		System.out.println("주소를 입력하세요"); // 입력할 내용에 대해 안내해야 한다.
//		String msg = sc.nextLine(); // 다음 엔터까지 값을 받는다.
//		System.out.println(msg);
//
//		System.out.println(":::::::::::::::::::::");
//		System.out.println("주소를 입력하세요.");
//		msg = sc.next(); // 다음 공백까지 값을 받는다.
//		sc.nextLine(); // 새로운 개행, 새로운 개행을 해주지 않으면 값이 남아 있어 다음 nextLine()까지 나온다.
//		System.out.println(msg);
//
//		System.out.println(":::::::::::::::::::::");
//		System.out.println("초등학교 주소를 입력하세요.");
//		msg = sc.nextLine();
//		System.out.println(msg);

		System.out.println(":::::::::::::::::::::");
		System.out.println("나이를 입력하세요.");
		int age = sc.nextInt(); // 엔터로 값이 입력되고, 이후 nextLine을 호출하지 않으면 다음 nextLine때 엔터를 만났다고 생각해 끝나버린다.
		sc.nextLine();
		System.out.println(age);

		System.out.println(":::::::::::::::::::::");
		System.out.println("배송지를 입력하세요");
		String msg = sc.nextLine();
		System.out.println(msg);

//		new AAA().me1(); // Scanner 객체를 여러 개 만들면 에러가 날 수 있으니 1개만 만들어 돌려서 사용할 것
		new AAA().me1(sc);

		sc.close();// 꼭 닫아주어야 한다.
	}
}
