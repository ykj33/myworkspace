package kr.co.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;

// 어노테이션이 붙어야 한다.
// 다른 이름의 어노테이션이 붙어도 돌아는 가지만 직관적으로 보여줄 수 있는 단어를 해야 한다.
@Repository
public class MemberDAOImpl implements MemberDAO {

	// 기 제작된 것을 사용할 때
	@Autowired
	private SqlSession session;

	// 일일히 치기 힘드므로 상수로 선언
	private final String NS = "m.e.m";

	// 추상메소드 구현
	@Override
	public void insert(MemberDTO dto) {
		// 해당 네임스페이스의 id값을 찾아서 실행
		session.insert(NS + ".insert", dto);
	}

	@Override
	public List<MemberDTO> list() {
		// 여러개 불러올 것이므로 selectList
		// 반환하는 값이 있을 경우 해당 메소드를 리턴해준다.
		return session.selectList(NS + ".list");

	}

	@Override
	public MemberDTO read(String id) {

		return session.selectOne(NS + ".read", id);
	}

	@Override
	public MemberDTO updateui(String id) {
		return session.selectOne(NS + ".updateui", id);
	}

	@Override
	public void update(MemberDTO dto) {
		session.update(NS + ".update", dto);

	}

	@Override
	public void delete(String id) {
		session.delete(NS + ".delete", id);

	}
	
	@Override
	public MemberDTO loginpost(LoginDTO login) {
		
		return session.selectOne(NS + ".loginpost", login);
	}
}
