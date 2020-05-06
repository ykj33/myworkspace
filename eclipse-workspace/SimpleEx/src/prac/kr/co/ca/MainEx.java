package prac.kr.co.ca;

import prac.com.naver.Bow;
import prac.com.naver.Hammer;
import prac.com.naver.Hero;
import prac.com.naver.Monster;
import prac.com.naver.NoHaveWeaponException;
import prac.com.naver.Sword;
import prac.com.naver.Weapon;

public class MainEx {
	public static void main(String[] args) {
		Monster m = new Monster(10);
		Weapon[] weapons = { new Bow("활", 1), new Sword("검", 5), new Hammer("망치", 10) };
		int hasWeaponIndex = 0;

		Hero spiderman = new Hero(weapons, hasWeaponIndex);
		spiderman.attack(m);
		try {
			spiderman.changeWeapon(1);
		} catch (NoHaveWeaponException e) {
			// TODO Auto-generated catch block
			System.out.println("무기 교체에 실패하였습니다.");
		}
		try {
			spiderman.changeWeapon(100);
		} catch (NoHaveWeaponException e) {
			System.out.println("무기 교체에 실패하였습니다.");
		}

	}
}
