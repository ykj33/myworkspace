package storage.com.naver;

import java.util.Scanner;
import storage.delete.DeleteCommand;
import storage.insert.InsertCommand;
import storage.kr.co.ca.StorageCommand;
import storage.select.SelectCommand;
import storage.update.UpdateCommand;

public class Process {
	public Process() {
		StorageCommand[] command = { new InsertCommand(), new SelectCommand(), new UpdateCommand(),
				new DeleteCommand() };

		boolean isTrue = true;
		int menu = -1;
		Scanner sc = new Scanner(System.in);

		while (isTrue) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.println(
					"---------------------------------------------------------------------------------------------");
			System.out.println("0: 창고 정보 입력 | 1: 창고 정보 조회 | 2: 창고 정보 수정 | 3: 창고 정보 삭제 | 4: 돌아가기");
			System.out.println(
					"---------------------------------------------------------------------------------------------");
			menu = sc.nextInt();
			sc.nextLine();

			if (menu < command.length) {
				command[menu].execute(sc);
			} else {
				isTrue = false;
			}
		}
		System.out.println("창고 관리 종료");

	}
}
