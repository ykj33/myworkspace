package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.DepartDTO;
import kr.co.persistence.DepartDAO;

@Service
// 자동으로 트랜잭션 구현
@Transactional
public class DepartServiceImpl implements DepartService {
	@Autowired
	private DepartDAO dDao;

	@Override
	public void insert(DepartDTO dto) {
		dDao.insert(dto);

	}

	@Override
	public List<DepartDTO> list() {
		// TODO Auto-generated method stub
		return dDao.list();
	}

	@Override
	public DepartDTO read(String did) {
		// TODO Auto-generated method stub
		return dDao.read(did);
	}

	@Override
	public DepartDTO updateui(String did) {
		
		return dDao.updateui(did);
	}
	@Override
	public void update(DepartDTO dto) {
		dDao.update(dto);
		
	}
	
	@Override
	public void delete(String did) {
		dDao.delete(did);
		
	}
}
