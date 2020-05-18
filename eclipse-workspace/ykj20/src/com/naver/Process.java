package com.naver;

import java.util.Scanner;

import a.InsertCommand;
import b.SelectCommand;
import d.DeleteCommand;
import e.SearchByIdCommand;
import f.SearchByNameCommand;
import g.SearchByAgeCommand;
import c.UpdateCommand;
import kr.co.ca.Command;

public class Process {
	public Process() {
		// TODO Auto-generated constructor stub
		Command[] command = { new InsertCommand(), new SelectCommand(), new UpdateCommand(), new DeleteCommand() };
		Command[] searchCommand = { new SearchByIdCommand(), new SearchByNameCommand(), new SearchByAgeCommand() };
		int menu = -1;
		boolean isTrue = true;
		Scanner sc = new Scanner(System.in);
		while (isTrue) {

			System.out.println("메뉴를 선택해주세요.");
			System.out.println("0: 입력, 1: 조회, 2: 수정, 3: 삭제, 4: 검색, 5: 종료");
			menu = sc.nextInt();
			sc.nextLine();
			if (menu == 4) {
				System.out.println("검색 방법을 선택하세요.");
				System.out.println("0: 아이디로 검색, 1: 이름으로 검색, 2: 나이로 검색");
				menu = sc.nextInt();
				sc.nextLine();
				searchCommand[menu].execute(sc);
			} else if (menu < command.length) {
				command[menu].execute(sc);
			} else {
				isTrue = false;
			}
		}
		System.out.println("프로그램 종료");

		sc.close();
	}
}
