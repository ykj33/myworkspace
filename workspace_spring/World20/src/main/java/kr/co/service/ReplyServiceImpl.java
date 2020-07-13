package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.ReplyVO;
import kr.co.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO rDao;

	@Override
	public int insert(ReplyVO vo) {
		// TODO Auto-generated method stub
		return rDao.insert(vo);
	}

	@Override
	public List<ReplyVO> list(int bno) {

		return rDao.list(bno);
	}

	@Override
	public int update(ReplyVO vo) {
		
		return rDao.update(vo);
	}
	@Override
	public int delete(int rno) {
		// TODO Auto-generated method stub
		return rDao.delete(rno);
	}
}
