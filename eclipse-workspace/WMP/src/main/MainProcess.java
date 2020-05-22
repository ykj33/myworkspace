package main;

import java.util.Scanner;

import main.search.SearchProcess;

public class MainProcess {
	public MainProcess() {

		boolean isRun = true;
		int menu = -1;
		Scanner sc = new Scanner(System.in);
		while (isRun) {
			System.out.println("======================");
			System.out.println("물류 관리 시스템");
			System.out.println("======================");
			System.out.println("메뉴를 선택해주세요.");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("1: 관리자 관리 | 2: 창고 관리 | 3: 물품 관리 | 4: 검색 | 5: 종료");
			System.out.println("-------------------------------------------------------------------");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				new manager.com.naver.Process();
				break;
			case 2:
				new storage.com.naver.Process();
				break;
			case 3:
				new product.com.naver.Process();
				break;

			case 4:
				new SearchProcess();
				break;
			case 5:

				isRun = false;

			}
		}
		System.out.println("시스템 종료");
		sc.close();
	}
}
