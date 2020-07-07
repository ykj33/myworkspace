package kr.co.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Autowired
	private SqlSession session;

	private final String NS = "r.e.p";

	@Override
	public int insert(ReplyVO vo) {
		// rno를 만들어서 넣어준다.
		Integer rno = session.selectOne(NS + ".getRno");
		vo.setRno(rno);
		return session.insert(NS + ".insert", vo);
	}

	@Override
	public List<ReplyVO> list(int bno) {
		// TODO Auto-generated method stub
		return session.selectList(NS + ".list", bno);
	}

	@Override
	public int update(ReplyVO vo) {
		
		return session.update(NS + ".update", vo);
	}
	@Override
	public int delete(int rno) {
		// TODO Auto-generated method stub
		return session.delete(NS + ".delete", rno);
	}
}
