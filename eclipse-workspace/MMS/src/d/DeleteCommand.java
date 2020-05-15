package d;

import java.util.Scanner;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class DeleteCommand implements Command {
	@Override
	public void execute(Scanner sc) {
		System.out.println("삭제할 아이디를 입력해주세요.");
		String id = sc.nextLine();

		// delete() 메소드 사용을 위한 dao 객체 생성
		MemberDAO dao = new MemberDAO();
		// delete() 메소드는 파라미터로 id를 받으므로 id 입력
		dao.delete(id);
	}
}
