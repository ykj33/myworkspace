package com.naver;

public class Hammer extends Weapon {
	public Hammer() {
		// TODO Auto-generated constructor stub
	}

	// 사용자 정의 생성자를 만들어도 값을 넣을 변수가 없기에, 부모의 변수를 가져와야 한다.
	public Hammer(String name, int attackPower) {
		// Bow가 생성될 때 Weapon 객체도 같이 생성되게 한다.
		// 그래서 Weapon 객체를 이용할 수 있도록 한다.
		super(name, attackPower);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void describe() {
		System.out.println("망치를 마구 휘두릅니다.");

	}

	@Override
	public String toString() {
		// 부모 객체가 가지고 있는 name을 가져와라
		// 그냥 getName을 해도 상속받았기에 사용 가능하다.
//		return super.getName(); 둘 다 가능함
		return getName(); // 둘 다 가능함
	}
}
