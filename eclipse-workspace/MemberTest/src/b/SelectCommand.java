package b;

import java.util.List;
import java.util.Scanner;

import com.naver.DB;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class SelectCommand implements Command {
	@Override
	public void execute(Scanner sc) {
		// 자주 보았던 List에 값을 할당, 그냥 DB.db로 이용해도 상관없다.
		List<MemberDTO> list = DB.db;
		
		for(int i = 0; i<list.size(); i++) {
			MemberDTO dto = list.get(i);
			System.out.println(dto); // 개별 값을 보고 싶으면 .get~~~로 획득
		}

	}
}
