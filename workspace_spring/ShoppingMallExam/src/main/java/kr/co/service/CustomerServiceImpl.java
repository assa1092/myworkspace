package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.FaqDTO;
import kr.co.domain.PageTO;
import kr.co.domain.QnaAttachDTO;
import kr.co.domain.QnaDTO;
import kr.co.persistence.CustomerServiceDAO;

@Service
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	private CustomerServiceDAO pcDao;
	
///////////////////////////////Q&A///////////////////////////////
	@Transactional
	@Override
	public void qnaInsert(QnaDTO qdto) {
		pcDao.qnaInsert(qdto);
		
		String[] files = qdto.getFiles();
		if (files!=null) {
			for(String fullName : files) {
				pcDao.qnaAddAttach(fullName, qdto.getQnaNo());
			}
		}
	}
	
	public List<QnaDTO> qnaList() {
		
		return pcDao.qnaList();
	}

	@Transactional
	@Override
	public QnaDTO qnaRead(int qnaNo) {
		pcDao.qnaIncreaseViewcnt(qnaNo);
		return pcDao.qnaRead(qnaNo);
	}
	
	@Override
	public QnaDTO qnaUpdateUI(int qnaNo) {
		
		return pcDao.qnaUpdateUi(qnaNo);
	}

	@Transactional
	@Override
	public void qnaUpdate(QnaDTO qdto) {
		pcDao.qnaUpdate(qdto);
		
		pcDao.qnaDeleteByQnaNo(qdto.getQnaNo());
		
		String[] files = qdto.getFiles();
		if(files != null) {
			for(String fullName : files) {
				pcDao.qnaAddAttach(fullName, qdto.getQnaNo());
			}
		}
	}


	@Transactional
	@Override
	public void qnaDelete(int qnaNo) {
		
		pcDao.qnaDelete(qnaNo);
		pcDao.qnaDeleteByQnaNo(qnaNo);
	}

	@Override
	public PageTO<QnaDTO> qnaList(PageTO<QnaDTO> qto) {
		
		return pcDao.qnaList(qto);
	}
	@Override
	public List<QnaDTO> qnaSearchlist(String searchType, String keyword) {
		
		return pcDao.qnaSearchlist(searchType, keyword);
	}

	@Override
	public List<String> getQnaAttach(Integer qnaNo) {
		
		return pcDao.getQnaattach(qnaNo);
	}

	@Override
	public void qnaDeleteAttachByFileName(String filename) {
		
		pcDao.qnaDeleteAttachByFileName(filename);
	}
	///////////////////////////////FAQ///////////////////////////////
	@Transactional
	@Override
	public void faqInsert(FaqDTO fdto) {
		
		pcDao.faqInsert(fdto);
		
	}

	@Override
	public PageTO<FaqDTO> faqList(PageTO<FaqDTO> fto) {
	
		return pcDao.faqList(fto);
	}

	@Override
	public List<FaqDTO> faqSearchlist(String searchType, String keyword) {
		
		return pcDao.faqSearchlist(searchType, keyword);
	}
	@Transactional
	@Override
	public FaqDTO faqRead(int faqNo) {
		pcDao.faqIncreaseViewcnt(faqNo);
		return pcDao.faqRead(faqNo);
	}

	@Override
	public void faqUpdate(FaqDTO fdto) {
		
		pcDao.faqUpdate(fdto);
		
		pcDao.faqDeleteByQnaNo(fdto.getFaqNo());
	}

	@Override
	public FaqDTO faqUpdateUI(int faqNo) {
		
		return pcDao.faqUpdateUI(faqNo);
	}

	@Override
	public void faqDelete(int faqNo) {
		
		pcDao.faqDelete(faqNo);
		pcDao.faqDeleteByQnaNo(faqNo);
		
	}
	
	
	
	
	
	
	
	
	
	
}
