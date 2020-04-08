package chap06.exercises.ex20;

import java.security.acl.Owner;
import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static int size = 0; // 계좌의 개수 추가
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("----------------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("----------------------------------------------------------");
			System.out.print("선택>");

			int selectNo = scanner.nextInt();
			scanner.nextLine(); // 바로 nextLine을 만나면 공백이라 개행되기 때문에 한 줄 더 써서 방지

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
		System.out.println("----------");
		System.out.println("계좌생성");
		System.out.println("----------");
		System.out.println("계좌번호를 입력해주세요.");
		String ano = scanner.nextLine();
		System.out.println("계좌주를 입력해주세요.");
		String owner = scanner.nextLine();
		System.out.println("초기입금액을 입력해주세요.");
		int balacne = Integer.parseInt(scanner.nextLine());

		accountArray[size] = new Account(ano, owner, balacne);
		size++;
		System.out.println("계좌가 생성되었습니다.");
	}

	// 계좌 목록보기
	private static void accountList() {
		System.out.println("----------");
		System.out.println("계좌목록");
		System.out.println("----------");
		for (int i = 0; i < size; i++) {
			System.out.println(
					accountArray[i].getAno() + "\t" + accountArray[i].getOwner() + "\t" + accountArray[i].getBalance());
		}
	}

	// 예금하기
	private static void deposit() {

		System.out.println("----------");
		System.out.println("예금");
		System.out.println("----------");
		System.out.println("계좌번호");
		String ano = scanner.nextLine();
		Account account = findAccount(ano);
		System.out.println("예금액 : ");
		int money = scanner.nextInt();
		scanner.nextLine();
		account.setBalance(account.getBalance() + money);
		System.out.println("예금이 성공되었습니다.");
		System.out.println("잔액 : " + account.getBalance());
	}

	// 출금하기
	private static void withdraw() {
		System.out.println("----------");
		System.out.println("출금");
		System.out.println("----------");
		System.out.println("계좌번호");
		String ano = scanner.nextLine();
		Account account = findAccount(ano);
		System.out.println("출금액 : ");
		int money = scanner.nextInt();
		scanner.nextLine();
		account.setBalance(account.getBalance() - money);
		System.out.println("출금이 완료되었습니다.");
		System.out.println("잔액 : " + account.getBalance());

	}

// Account 배열에서 ano와 동일한 Account 객체 찾기
	private static Account findAccount(String ano) {
		for (int i = 0; i <= size; i++) {
			if (accountArray[i].getAno().equals(ano)) {
				return accountArray[i]; // 계좌 자체를 리턴하면 된다.
			}
		}
		return null; // 없으면 그냥 없다고 반환 return 값이 꼭 있어야 한다.

	}
}
