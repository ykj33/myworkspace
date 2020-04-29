package kr.co.kr;

import com.naver.Bow;
import com.naver.Hammer;
import com.naver.Hero;
import com.naver.Monster;
import com.naver.NoHaveWeaponException;
import com.naver.Sword;
import com.naver.Weapon;

public class MainEx {
	public static void main(String[] args) {
		Monster m = new Monster(10);
		// 무기 DB 생성
		Weapon[] weapons = { new Bow("활", 1), new Sword("검", 5), new Hammer("망치", 10) };
		int hasWeaponIdx = 0;

		// 히어로 생성
		Hero spiderman = new Hero(weapons, hasWeaponIdx);
		spiderman.attack(m);
		spiderman.attack(m);
		try {
			spiderman.changeWeapon(1);
		} catch (NoHaveWeaponException e) {
			// TODO Auto-generated catch block
			System.out.println("무기 변경에 실패했습니다.");
		}
		spiderman.attack(m);

		try {
			spiderman.changeWeapon(100);
		} catch (NoHaveWeaponException e) {
			// TODO Auto-generated catch block
			System.out.println("무기 변경에 실패했습니다.");
		}

	}
}
