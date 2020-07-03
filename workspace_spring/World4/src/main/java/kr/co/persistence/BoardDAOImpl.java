package kr.co.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession session;

	private final String NS = "b.o.a";

	@Override
	public void insert(BoardVO vo) {

		Integer bno = session.selectOne(NS + ".getBno");
		if (bno != null) {
			bno += 1;
		} else {
			bno = 1;
		}
		// vo에 bno값 넣어주기
		vo.setBno(bno);
		session.insert(NS + ".insert", vo);
	}

	@Override
	public List<BoardVO> list() {

		return session.selectList(NS + ".list");
	}

	@Override
	public BoardVO read(int bno) {

		return session.selectOne(NS + ".read", bno);

	}

	@Override
	public void increaseViewcnt(int bno) {
		session.update(NS + ".increaseViewcnt", bno);

	}

	@Override
	public BoardVO updateUI(int bno) {

		return session.selectOne(NS + ".updateUI", bno);
	}

	@Override
	public void update(BoardVO vo) {
		session.update(NS + ".update", vo);
	}

	@Override
	public void delete(int bno) {
		session.delete(NS + ".delete", bno);
	}
}
