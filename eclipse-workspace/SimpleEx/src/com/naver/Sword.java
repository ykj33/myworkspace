package com.naver;

public class Sword extends Weapon {

	// 부모 클래스가 가지고 있는 필드를 가지고 와 생성자를 만든다.
	public Sword(String name, int attackPower) {
		super(name, attackPower);
		// TODO Auto-generated constructor stub
	}

	public Sword() {

	}

	@Override
	public void describe() {
		System.out.println("칼로 마구 찌릅니다.");
	}

	@Override
	public String toString() {
		// 부모 객체가 가지고 있는 name을 가져와라
		// 그냥 getName을 해도 상속받았기에 사용 가능하다.
//		return super.getName(); 둘 다 가능함
		return getName(); // 둘 다 가능함
	}

}
