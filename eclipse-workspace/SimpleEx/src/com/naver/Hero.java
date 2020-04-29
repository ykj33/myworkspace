package com.naver;

public class Hero {
	// 배열로 하면 여러개를 넣을 수 있다. 확장성이 있음. 그리고 부모클래스의 타입으로 선언하여 다형성 이용 가능
	private Weapon[] weapons;
	private Weapon hasWeapon;

	// 무기를 여러 개 소지함
	public Hero() {
		// 네트워크가 여의치 않는 등의 제한적인 상황에서 게임을 하고 싶을 때를 위해 default 생성자에서
		// 무기 DB를 구현해놓았다.
		weapons = new Weapon[] { new Bow("활", 1), new Sword("검", 5), new Hammer("망치", 10) };
		hasWeapon = weapons[0];
	}

	// 무기를 손에 쥠
	public Hero(Weapon[] weapons, int idx) {
		super();
		this.weapons = weapons;
		this.hasWeapon = weapons[idx];
	}

	// 몬스터를 공격함
	public void attack(Monster m) {
		hasWeapon.attack(m);
	}

	public void changeWeapon(int idx) throws NoHaveWeaponException {
		// 확장성을 위해 .length를 사용
		// 되도록이면 사용자 정의 예외 처리를 해서 문제를 처리하도록 하자
		// 문법적으로 이상이없는데 논리적으로 이상한 경우 throw로 예외 처리 필요
		if (idx >= weapons.length) {
			throw new NoHaveWeaponException();
		}
		hasWeapon = weapons[idx];
		System.out.println(hasWeapon);
	}

}
