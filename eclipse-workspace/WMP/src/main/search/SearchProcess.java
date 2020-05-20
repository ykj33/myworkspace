package main.search;

import java.util.Scanner;

import main.MainCommand;

public class SearchProcess {
	public SearchProcess() {
		MainCommand[] command = {new SearchByIdCommand(), new SearchByPName()};
		boolean isRun = true;
		int menu = -1;
		Scanner sc = new Scanner(System.in);
		
		while (isRun) {
			
			System.out.println("메뉴를 선택해주세요.");
			System.out.println("0:관리자아이디로 검색 , 1:제품명으로 검색 , 2: 돌아가기");
			menu = sc.nextInt();
			sc.nextLine();
			
			if(menu < command.length) {
				command[menu].execute(sc);
			} else {
				isRun = false;
			}
		}

		
	}
}
