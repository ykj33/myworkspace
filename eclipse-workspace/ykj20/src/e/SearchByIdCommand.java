package e;

import java.util.List;
import java.util.Scanner;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class SearchByIdCommand implements Command {
	@Override
	public void execute(Scanner sc) {
		System.out.println("검색할 아이디를 입력하세요.");
		String id = sc.nextLine();
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.searchById(id);
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
