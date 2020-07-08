package kr.co.persistence;

import java.util.List;

import kr.co.domain.MemberDTO;

public interface MemberDAO {
	// DAO에서 추상메소드 선언
	void insert(MemberDTO dto);

	List<MemberDTO> list();

	MemberDTO read(String id);

	MemberDTO updateui(String id);

	void update(MemberDTO dto);

	void delete(String id);

}
