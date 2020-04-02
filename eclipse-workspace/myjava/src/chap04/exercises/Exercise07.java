package chap04.exercises;

import java.util.Scanner;

public class Exercise07 {
	public static void main(String[] args) {
		boolean run = true;

		int balance = 0;

		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("------------------------------------------");
			System.out.println("1. 입금 | 2. 출금 | 3. 잔고 | 4.종료");
			System.out.println("------------------------------------------");
			System.out.print("선택 > ");

			String input = scanner.nextLine(); // while문 안에서 값을 받고, 다시 돌아왔을 때 값을 받을 준비가 되어 있어야 무한루프가 돌지 않는다.
			int keyCode = Integer.parseInt(input);

			if (keyCode == 1) {
				System.out.println("입금액 > ");
				String plus = scanner.nextLine(); // 입금액 입력 준비
				int plusMoney = Integer.parseInt(plus); // 받은 데이터를 정수로 치환
				balance += plusMoney; // 더하기

				System.out.println(balance);

			} else if (keyCode == 2) {
				System.out.println("출금액 > ");
				String minus = scanner.nextLine(); // 출금액 입력 준비
				int minusMoney = Integer.parseInt(minus); // 받은 데이터를 정수로 치
				balance -= minusMoney; // 빼기
				System.out.println(balance);

			} else if (keyCode == 3) {
				System.out.println(balance);

			} else if (keyCode == 4) {
				run = false;
			}

			// 선생님의 방법
//			switch (input) {
//			case "1":
//				System.out.print("예금액 >");
//				String moneyStr = scanner.nextLine();
//				int money = Integer.parseInt(moneyStr);
//				balance += money;
//				break;
//			case "2":
//				System.out.print("출금액 >");
//				String moneyStr2 = scanner.nextLine();
//				int money2 = Integer.parseInt(moneyStr2);
//				balance -= money2;
//				break;
//			case "3":
//				System.out.print("잔고 >");
//				System.out.println(balance);
//				break;
//			case "4":
//				run = false;
//				break;
//			default:
//				break;
//			}
		}
		System.out.println("프로그램 종료");
	}
}
