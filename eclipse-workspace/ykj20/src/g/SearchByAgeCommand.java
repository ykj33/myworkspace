package g;

import java.util.List;
import java.util.Scanner;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class SearchByAgeCommand implements Command {
	@Override
	public void execute(Scanner sc) {
		System.out.println("검색할 나이를 입력하세요.");
		int age = sc.nextInt();
		sc.nextLine();
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.searchByAge(age);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
