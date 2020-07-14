package kr.co.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;

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

	@Override
	public PageTO<BoardVO> list(PageTO<BoardVO> to) {
		// mybatis에서는 시작을 0부터 하므로, startNum에서 1을 빼야 한다.
		// 그리고 한 페이지에 몇개를 가져올 것인지
		RowBounds rowBounds = new RowBounds(to.getStartNum() - 1, to.getPerPage());
		// 2번째 파라미터는 검색할 때 검색어를 넣는다.
		List<BoardVO> list = session.selectList(NS + ".list", null, rowBounds);
		// to의 list에 만들어놓은 list를 넣어준다.
		to.setList(list);

		Integer amount = session.selectOne(NS + ".getAmount");
		if (amount != null) {
			to.setAmount(amount);
		} else {
			to.setAmount(0);
		}
		return to;
	}

	@Override
	public List<BoardVO> searchlist(String searchType, String keyword) {
		// 파라미터는 2개인데 넣을 수 있는 것은 1개
		// 자주 사용할 경우 만들면 되지만 그렇지 않을 경우 Map을 이용하여 넣을 수 있다.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		return session.selectList(NS + ".searchlist", map);
	}

	@Override
	public void addAttach(String fullName, int bno) {
		Integer id = session.selectOne(NS + ".getId");
		// 파라미터는 2개이고 값은 여러개라면 Map을 만들어 사용한다.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("fullName", fullName);
		map.put("bno", bno);
		session.insert(NS + ".addAttach", map);
	}

	@Override
	public List<String> getAttach(Integer bno) {
		// TODO Auto-generated method stub
		return session.selectList(NS + ".getAttach", bno);
	}

	@Override
	public void deleteAttachByFileName(String filename) {
		session.delete(NS + ".deleteAttachByFileName", filename);

	}
	
	@Override
	public void deleteByBno(int bno) {
		session.delete(NS + ".deleteByBno", bno);
		
	}
}
