package prac.kr.co.ca;

import prac.com.naver.Sword;

import prac.com.naver.Bow;
import prac.com.naver.Hammer;
import prac.com.naver.Hero;
import prac.com.naver.Monster;
import prac.com.naver.NoHaveWeaponException;
import prac.com.naver.Weapon;

public class MainEx {
	public static void main(String[] args) {
		Monster m = new Monster(10);
		Weapon weapons[] = { new Bow("활", 1), new Sword("검", 5), new Hammer("망치", 10) };
		int hasWeaponIdx = 0;

		Hero man = new Hero(weapons, hasWeaponIdx);
		man.attack(m);
		try {
			man.changeWeapon(1);
		} catch (NoHaveWeaponException e) {
			// TODO Auto-generated catch block
			System.out.println("무기 변경에 실패했습니다.");
		}
		try {
			man.changeWeapon(100);
		} catch (NoHaveWeaponException e) {
			// TODO Auto-generated catch block
			System.out.println("무기 변경에 실패했습니다.");
		}
	}
}
