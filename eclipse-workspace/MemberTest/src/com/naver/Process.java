package com.naver;

import java.util.Scanner;

import a.InsertCommand;
import b.SelectCommand;
import c.UpdateCommand;
import d.DeleteCommand;
import kr.co.ca.Command;

public class Process {
	public Process() {
		// Command배열로 묶어 각 가능을 구현
		Command[] command = { new InsertCommand(), new SelectCommand(), new UpdateCommand(), new DeleteCommand() };

		boolean isTrue = true; // 무한루프를 돌리기 위한 변수 선언
		int menu = -1; // 메뉴 선택

		Scanner sc = new Scanner(System.in);
		while (isTrue) {
			System.out.println("메뉴를 선택하세요.");
			System.out.println("0: 입력, 1: 조회, 2: 수정, 3: 삭제, 4: 종료");

			menu = sc.nextInt();
			sc.nextLine();

			// 메뉴 값이 0,1,2,3인 경우 작업을 하고 나머지는 종료
			if (menu < command.length) {
				// 해당 인덱스에 있는 배열 요소를 호출하여 실행
				command[menu].execute(sc);
			} else {
				isTrue = false;
			}
		}
		System.out.println("시스템종료");
		// 닫아주어야 한다.
		sc.close();
	}
}
