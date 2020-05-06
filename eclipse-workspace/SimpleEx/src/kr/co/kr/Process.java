package kr.co.kr;

import java.util.Scanner;

import com.naver.Bow;
import com.naver.Hammer;
import com.naver.Hero;
import com.naver.Monster;
import com.naver.NoHaveWeaponException;
import com.naver.Sword;
import com.naver.Weapon;

public class Process {
	public Process() {
		// 각각의 객체들 만들기
		Monster m = new Monster(100);
		Weapon[] weapons = { new Bow("활", 1), new Sword("검", 5), new Hammer("망치", 10) };
		int hasidx = 0;
		Hero spiderman = new Hero(weapons, hasidx);

		// Scanner 객체 생성
		Scanner sc = new Scanner(System.in); // 표준 입력장치 - 키보드
		boolean isTrue = true;

		while (isTrue) {
			System.out.println("menu를 선택하시오.");
			System.out.println("1: 공격, 2: 무기 변경, 3: 종료");
			// 정수값을 받는다.
			int menu = sc.nextInt();
			sc.nextLine(); // nextLine()을 제외한 다른 메소드의 뒤에는 꼭 nextLine()을 붙여야 함

			switch (menu) {
			case 1:
				spiderman.attack(m);
				break;
			case 2:
				System.out.println("무기를 선택하시오.");
				int idx = 0;
				// 무기는 늘어날 수 있기 때문에 for 문으로 출력한다.
				for (Weapon w : weapons) {
					// 무기의 번호가 1씩 늘어난다.
					System.out.print(idx++);
					System.out.print(": ");
					// 무기 종류 출력
					System.out.print(w);

					// 마지막에 ,를 찍어주지 않으려 한다.
					if (idx < weapons.length) {
						System.out.print(", ");
					}
				}
				System.out.println();
				// 스캐너로 값 받기
				int widx = sc.nextInt();
				sc.nextLine();
				try {
					spiderman.changeWeapon(widx);
				} catch (NoHaveWeaponException e) {
					System.out.println("무기 변경 실패");
				}
				break;
			// 1,2 이외의 값이 들어올 시 종료
			default:
				isTrue = false;
				break;
			}

		}
		sc.close();

// 내가 한 코드
//public class Process {
//	public void process() {
//		Scanner scanner = new Scanner(System.in);
//
//		// 몬스터 생성
//		Monster m = new Monster(10);
//		// 무기 생성
//		Weapon[] weapons = { new Bow("활", 1), new Sword("검", 5), new Hammer("망치", 10) };
//		int hasWeaponIdx = 0;
//
//		Hero spiderman = new Hero(weapons, hasWeaponIdx);
//		boolean run = true;
//		while (run) {
//
//			System.out.println("============================================");
//			System.out.println("행동을 선택하세요");
//			System.out.println("--------------------------------------------");
//			System.out.println("1. 공격 | 2. 무기교체 | 3. 종료");
//			String s1 = scanner.nextLine();
//
//			switch (s1) {
//			case "1":
//				spiderman.attack(m);
//				if (m.getHp() <= 0) {
//					System.out.println("몬스터가 사망하였습니다.");
//
//				}
//				break;
//			case "2":
//				System.out.println("바꿀 무기를 선택하세요.");
//				System.out.println("0. 활 | 1. 검 | 2. 망치");
//				try {
//					spiderman.changeWeapon(Integer.parseInt(scanner.nextLine()));
//				} catch (NoHaveWeaponException e1) {
//					System.out.println("무기 교체에 실패하였습니다.");
//				}
//				break;
//			case "3":
//				System.out.println("게임이 종료됩니다.");
//				run = false;
//				break;
//
//			}
//		}
//		// 공격
//		spiderman.attack(m);
//		// 무기 교체
//		try {
//			spiderman.changeWeapon(1);
//		} catch (NoHaveWeaponException e) {
//			System.out.println("무기 교체에 실패하였습니다.");
//		}
//		try {
//			spiderman.changeWeapon(100);
//		} catch (NoHaveWeaponException e) {
//			System.out.println("무기 교체에 실패하였습니다.");
//		}
	}
}
