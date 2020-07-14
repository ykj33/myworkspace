package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;
import kr.co.persistence.MemberDAO;

// 어노테이션이 없으면 Autowired에서 찾을 수 없다.
@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO memberDao;

// 인터페이스에서 추상메소드로 선언했으므로 구현
// 그러나 service에서 구현하지 않기 때문에 dao에서 선언
	@Override
	public void insert(MemberDTO dto) {
		memberDao.insert(dto);

	}

	@Override
	public List<MemberDTO> list() {
		return memberDao.list();

	}

	@Override
	public MemberDTO read(String id) {

		return memberDao.read(id);
	}

	@Override
	public MemberDTO updateui(String id) {

		return memberDao.updateui(id);
	}

	@Override
	public void update(MemberDTO dto) {
		memberDao.update(dto);
	}

	@Override
	public void delete(String id) {
		memberDao.delete(id);

	}
	
	@Override
	public MemberDTO loginpost(LoginDTO login) {
		// TODO Auto-generated method stub
		return memberDao.loginpost(login);
	}
}
