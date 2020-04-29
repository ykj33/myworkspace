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
		// 몬스터 생성
		Monster m = new Monster(10);
		// 무기 생성
		Weapon[] weapons = { new Bow("활", 1), new Sword("검", 5), new Hammer("망치", 10) };
		int hasWeaponIdx = 0;

		Hero spiderman = new Hero(weapons, hasWeaponIdx);
		// 공격
		spiderman.attack(m);
		// 무기 교체
		try {
			spiderman.changeWeapon(1);
		} catch (NoHaveWeaponException e) {
			System.out.println("무기 교체에 실패하였습니다.");
		}
		try {
			spiderman.changeWeapon(100);
		} catch (NoHaveWeaponException e) {
			System.out.println("무기 교체에 실패하였습니다.");
		}

	}
}
