package c;

import java.util.Scanner;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class UpdateCommand implements Command {
	@Override
	public void execute(Scanner sc) {
		System.out.println("수정할 아이디를 입력하세요.");
		String id = sc.nextLine();

		System.out.println("수정할 이름을 입력하세요.");
		String name = sc.nextLine();

		System.out.println("수정할 나이를 입력하세요.");
		int age = sc.nextInt();
		sc.nextLine();

		// 수정된 정보를 담는 dto 객체를 만든다.
		MemberDTO dto = new MemberDTO(id, name, age);
		
		// dao의 메소드를 사용하기 위해 dao 객체 생성
		MemberDAO dao = new MemberDAO();
		dao.update(dto);
	}
}
