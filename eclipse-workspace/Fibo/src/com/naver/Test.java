package com.naver;

public class Test {

	public void me2() {
		long[] arr = new long[100];
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 2] + arr[i - 1];

		}
		for (long x : arr) {
			System.out.println(x);
		}
	}

	// 간단하게
	public void me1() {
		int p2 = 1;
		int p1 = 1;
		System.out.println(p2);
		System.out.println(p1);
		int cur = -1; // 아무거나 주어도 상관은 없다.

		for (int i = 0; i < 98; i++) {
			cur = p2 + p1;
			System.out.println(cur);

			p2 = p1; // 전전 값이 전 값이 되고
			p1 = cur; // 전 값이 현재 값이 된다.
		}
	}
}
