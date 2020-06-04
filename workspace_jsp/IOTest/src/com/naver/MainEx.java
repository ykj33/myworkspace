package com.naver;

public class MainEx {
	public static void main(String[] args) {

		Test t2 = new Test();
		long start = System.currentTimeMillis();
		t2.me3();
		t2.me4();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("::::::::::::::::::::::::::::");

		Test t1 = new Test();
		start = System.currentTimeMillis();
		t1.me1();
		end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("========================");
		start = System.currentTimeMillis();
		t1.me2();
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
