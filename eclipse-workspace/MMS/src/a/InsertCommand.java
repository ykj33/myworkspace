package a;

import java.util.Scanner;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class InsertCommand implements Command {
	@Override
	public void execute(Scanner sc) {
		System.out.println("아이디를 입력하세요.");
		String id = sc.nextLine();
		System.out.println("이름을 입력하세요.");
		String name = sc.nextLine();
		System.out.println("나이를 입력하세요.");
		// 의도적으로 Wrapper 클래스를 이용하여 ""를 떼어준다.
		// jsp 등에서는 값을 문자열로 받아오기 때문.
		String sAge = sc.nextLine();
		int age = Integer.parseInt(sAge);

		MemberDTO dto = new MemberDTO(id, name, age);

		// 만들어 놓았던 MemberDAO 객체를 하나 만들고 거기에 dto 값을 입력한다.
		MemberDAO dao = new MemberDAO();
		dao.insert(dto);
	}
}
