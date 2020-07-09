package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.DepartDTO;
import kr.co.persistence.DepartDAO;

@Service
@Transactional	// 트랜젝션 처리....root-context.xml 에 조금 바꾸어줘야한다...Service 창에는 무조건 트랜잭션..적용
public class DepartServiceImpl implements DepartService {
	@Autowired
	private DepartDAO dDao;

	@Override
	public void insert(DepartDTO dto) {
		
		dDao.insert(dto);
		
	}

	@Override
	public List<DepartDTO> list() {
		return dDao.list();
		
	}

	@Override
	public DepartDTO read(String did) {
		
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
