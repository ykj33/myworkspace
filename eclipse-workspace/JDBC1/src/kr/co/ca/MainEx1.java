package kr.co.ca;

import com.naver.MemberDTO;
import com.naver.TestDAO;

public class MainEx1 {
	public static void main(String[] args) {
		TestDAO dao = new TestDAO();
//	dao.insert(new MemberDTO()); // 입력
//	dao.selectAll(); // 조회
//	dao.update(new MemberDTO()); // 수정

		MemberDTO dto = new MemberDTO("m001", "kim", 1);
		dao.insert(dto);
	}
}
