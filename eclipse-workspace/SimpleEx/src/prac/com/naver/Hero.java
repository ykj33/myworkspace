package prac.com.naver;

public class Hero {
	private Weapon[] weapons;
	private Weapon hasWeapon;

	public Hero() {
		weapons = new Weapon[] { new Bow("활", 1), new Sword("검", 5), new Hammer("망치", 10) };
		hasWeapon = weapons[0];
	}

	public Hero(Weapon[] weapons, int idx) {
		super();
		this.weapons = weapons;
		this.hasWeapon = hasWeapon;
		this.hasWeapon = weapons[idx];
	}

	public void attack(Monster m) {
		hasWeapon.attack(m);
	}

	public void changeWeapon(int idx) throws NoHaveWeaponException {
		if (idx >= weapons.length) {
			throw new NoHaveWeaponException();
		}
		hasWeapon = weapons[idx];
		System.out.println(hasWeapon);
	}
}
