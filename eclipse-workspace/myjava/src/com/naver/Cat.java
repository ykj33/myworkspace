package com.naver;

public class Cat {

	private int id;
	private String name;

	public Cat() {
	}

	public Cat(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void run(String where) {
		System.out.println(where + "로 달린다");
	}

	public void sleep() {
		System.out.println("잔다");
	}
}
