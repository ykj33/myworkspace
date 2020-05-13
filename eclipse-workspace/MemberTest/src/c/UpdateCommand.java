package c;

import java.util.Scanner;

import com.naver.DB;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class UpdateCommand implements Command {
	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("수정할 id를 입력하세요.");
		String id = sc.nextLine();
		// equals() 메소드가 id만 같으면 같다고 하였기 때문에 id값만 알면된다.
		// 회원이 존재한다는 것을 알게 됨
		MemberDTO dto = new MemberDTO(id, null, -1);
		// contains()메소드에 id를 넣으면 id는 String이기 때문에 타입 미스매치가 일어나므로 MemberDTO 타입으로 바꾸어주어야
		// 한다.
		Boolean isMember = DB.db.contains(dto);

		if (isMember) {
			System.out.println("수정할 이름을 입력하세요.");
			String name = sc.nextLine();
			System.out.println("수정할 나이를 입력하세요.");
			int age = sc.nextInt();
			sc.nextLine();
			// 이름과 나이를 바꿈, setter를 사용하는 것
			dto.setName(name);
			dto.setAge(age);
			// 해당 회원이 몇 번째 인덱스인지 알게 됨
			int idx = DB.db.indexOf(dto);
			DB.db.set(idx, dto);
		} else {
			System.out.println("회원이 아닙니다.");
		}
	}
}
