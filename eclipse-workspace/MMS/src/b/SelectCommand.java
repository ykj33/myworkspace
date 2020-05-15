package b;

import java.util.List;
import java.util.Scanner;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class SelectCommand implements Command {
	@Override
	public void execute(Scanner sc) {
		// dao 객체를 만들어 selectAll로 불러와 list에 넣어준다.
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.selectAll();

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
