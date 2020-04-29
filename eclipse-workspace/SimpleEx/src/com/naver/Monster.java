package com.naver;

public class Monster {
	private int hp;

	public Monster() {
		// TODO Auto-generated constructor stub
	}

	public Monster(int hp) {
		super();
		this.hp = hp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	// toString 재정의를 통해 원하는 값 출력 가능
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "monster hp : " + hp;
	}
}
