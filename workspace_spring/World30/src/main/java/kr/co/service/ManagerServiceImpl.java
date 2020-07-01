package kr.co.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.ManagerDTO;
import kr.co.persistence.ManagerDAO;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{
	@Autowired
	private ManagerDAO mDao;

	@Override
	public void insert(ManagerDTO dto) {
		mDao.insert(dto);
		
	}

}
