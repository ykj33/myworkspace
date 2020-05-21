package main.search;

import java.util.List;
import java.util.Scanner;

import main.MainCommand;

public class SearchByPNameCommand implements MainCommand {
	@Override
	public void execute(Scanner sc) {
		System.out.println("검색할 제품명을 입력해주세요.");
		String pname = sc.nextLine();

		SearchDAO sdao = new SearchDAO();
		List<WmpDTO> list = sdao.searchByPName(pname);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("=======================================");
			System.out.println("제품명  : " + list.get(i).getPname());
			System.out.println("제품종류 : " + list.get(i).getStype());
			System.out.println("보유창고위치 : " + list.get(i).getLocation());
			System.out.println("보유 수량 : " + list.get(i).getAmount());
			int price = list.get(i).getPrice();
			int discount = list.get(i).getDiscount();
			int total = (price - (price * discount) / 100);
			System.out.println("최종 가격 : " + total);
			System.out.println("=======================================");
		}
	}
}
