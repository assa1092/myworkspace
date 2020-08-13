package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.domain.QnaAttachDTO;
import kr.co.persistence.QnaAttahDAO;

public class QnaAttahServiceImpl implements QnaAttachService{

	@Autowired
	private QnaAttahDAO qaDao;

	@Override
	public List<QnaAttachDTO> list(int qnaNo) {
		// TODO Auto-generated method stub
		return qaDao.list(qnaNo);
	}

	@Override
	public int insert(QnaAttachDTO qadto) {
		// TODO Auto-generated method stub
		return qaDao.insert(qadto);
	}

	@Override
	public int update(QnaAttachDTO qadto) {
		// TODO Auto-generated method stub
		return qaDao.update(qadto);
	}

	@Override
	public int delete(QnaAttachDTO qadto) {
		// TODO Auto-generated method stub
		return qaDao.delete(qadto);
	}
	
}
