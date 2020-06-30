package kr.co.service;

import java.sql.Connection;
import java.util.List;

import kr.co.domain.MemberDTO;

public interface MemberService {

	// insert 메소드
	void insert(MemberDTO dto);

	List<MemberDTO> list();

	
	
	
}
