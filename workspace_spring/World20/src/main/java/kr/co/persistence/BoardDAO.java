package kr.co.persistence;

import java.util.List;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;

public interface BoardDAO {

	void insert(BoardVO vo);
	
	void addAttach(String fullName, int bno);

	List<BoardVO> list();

	BoardVO read(int bno);

	void increaseViewcnt(int bno);

	BoardVO updateUI(int bno);

	void update(BoardVO vo);

	void delete(int bno);

	PageTO<BoardVO> list(PageTO<BoardVO> to);

	List<BoardVO> searchlist(String searchType, String keyword);

	List<String> getAttach(Integer bno);
}
