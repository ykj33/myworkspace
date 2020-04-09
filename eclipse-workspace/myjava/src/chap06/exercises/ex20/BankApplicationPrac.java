package chap06.exercises.ex20;

import java.util.Scanner;

public class BankApplicationPrac {
	private static AccountPrac[] accountArray = new AccountPrac[100];
	private static int size = 0;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("1. 계좌 생성 | 2. 계좌 목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("-----------------------------------------------------------");
			System.out.print("선택 > ");

			int selectNo = scanner.nextInt();
			scanner.nextLine();

			if (selectNo == 1) {
				createAccount();
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");

	}

	// 계좌 생성하기
	private static void createAccount() {
		System.out.println("----------------");
		System.out.println("계좌 생성");
		System.out.println("----------------");
		System.out.println("계좌번호를 입력하세요.");
		String ano = scanner.nextLine();
		System.out.println("계좌주를 입력하세요.");
		String owner = scanner.nextLine();
		System.out.println("초기입금액을 입력하세요.");
		int balance = Integer.parseInt(scanner.nextLine());
		accountArray[size] = new AccountPrac(ano, owner, balance);
		size++;
	}

	// 계좌 목록보기
	private static void accountList() {
		for (int i = 0; i < size; i++) {
			System.out.println(
					accountArray[i].getAno() + "\t" + accountArray[i].getOwner() + "\t" + accountArray[i].getBalance());
		}
	}

	// 예금하기
	private static void deposit() {
		System.out.println("----------------");
		System.out.println("계좌 예금");
		System.out.println("----------------");
		System.out.println("계좌번호를 입력하세요.");
		String ano = scanner.nextLine();
		AccountPrac account = findAccount(ano);
		System.out.println("예금액을 입력하세요.");
		int input = Integer.parseInt(scanner.nextLine());
		account.setBalance(account.getBalance() + input);
		System.out.println("잔액 : " + account.getBalance());
	}

	// 출금하기
	private static void withdraw() {
		System.out.println("----------------");
		System.out.println("계좌 예금");
		System.out.println("----------------");
		System.out.println("계좌번호를 입력하세요.");
		String ano = scanner.nextLine();
		AccountPrac account = findAccount(ano);
		System.out.println("출금액을 입력하세요.");
		int input = Integer.parseInt(scanner.nextLine());
		account.setBalance(account.getBalance() - input);
		System.out.println("잔액 : " + account.getBalance());
	}

	// AcountPrac 배열에서 ano와 동일한 AccountPrac 객체 찾기
	private static AccountPrac findAccount(String ano) {
		for (int i = 0; i < size; i++) {
			if (accountArray[i].getAno().equals(ano)) {
				return accountArray[i];
			}
		}
		return null;
	}

}
