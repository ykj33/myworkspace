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
		if (hp <= 0) {
			this.hp = 0;
		}
	}

	// toString 재정의를 통해 원하는 hp값 출력 가능
	@Override
	public String toString() {
		return "monster hp: " + hp;
	}

}
