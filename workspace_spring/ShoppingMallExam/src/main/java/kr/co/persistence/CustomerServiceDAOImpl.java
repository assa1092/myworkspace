package kr.co.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.FaqDTO;
import kr.co.domain.PageTO;
import kr.co.domain.QnaDTO;

@Repository
public class CustomerServiceDAOImpl implements CustomerServiceDAO{

	@Autowired
	private SqlSession session;
	
	private final String NS = "c.u.s";

	/////////////////////////////Q&A//////////////////////////////////
	
	@Override
	public void qnaInsert(QnaDTO qdto) {
		Integer qnaNo = session.selectOne(NS+".getQnaNo");
		if (qnaNo != null) {
			qnaNo += 1;
		} else {
			qnaNo = 1;
		}
		qdto.setQnaNo(qnaNo);
		
		session.insert(NS +".qnaInsert", qdto);
		
	}
	@Override
	public List<QnaDTO> qnaList() {
		
		return session.selectList(NS+".qnaList");
	}

	@Override
	public QnaDTO qnaRead(int qnaNo) {
		
		return session.selectOne(NS+".qnaRead", qnaNo);
	}
	
	@Override
	public void qnaIncreaseViewcnt(int qnaNo) {
		
		session.update(NS+".qnaIncreaseViewcnt", qnaNo);
	}
	
	@Override
	public QnaDTO qnaUpdateUi(int qnaNo) {
		
		return session.selectOne(NS+".qnaUpdateUI", qnaNo);
	}
	
	@Override
	public void qnaUpdate(QnaDTO qdto) {
		
		session.update(NS+".qnaUpdate", qdto);
	}
	
	@Override
	public void qnaDelete(int qnaNo) {
		
		session.delete(NS+".qnaDelete", qnaNo);
	}

	@Override
	public PageTO<QnaDTO> qnaList(PageTO<QnaDTO> qto) {
		
		RowBounds rowBounds = new RowBounds(qto.getStartNum() -1, qto.getPerPage());
		
		List<QnaDTO> qlist = session.selectList(NS + ".qnaList", null, rowBounds);
		
		Integer amount = session.selectOne(NS+".getAmount");
		if (amount != null) {
			qto.setAmount(amount);
		} else {
			qto.setAmount(0);
		}
		
		return qto;
	}

	@Override
	public List<QnaDTO> qnaSearchlist(String searchType, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		return session.selectList(NS+".qnaSearchlist", map);
	}
	
	@Override
	public void qnaAddAttach(String fullName, int qnaNo) {
		Integer id = session.selectOne(NS+".getId");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("fullName", fullName);
		map.put("qnaNo", qnaNo);
		session.insert(NS+".qnaAddAttach", map);
		
	}
	
	@Override
	public void qnaUpdateAttach(String fullName, int qnaNo) {
		Integer id = session.selectOne(NS+".getId");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("fullName", fullName);
		map.put("qnaNo", qnaNo);
		session.update(NS+"qnaUpdateAttach", map);
	}

	@Override
	public void qnaDeleteByQnaNo(int qnaNo) {
		
		session.delete(NS+".qnaDeleteByQnaNo", qnaNo);
	}

 
	@Override
	public List<String> getQnaattach(Integer qnaNo) {
		
		return session.selectList(NS+".getQnaattach", qnaNo);
	}

	@Override
	public void qnaDeleteAttachByFileName(String filename) {
		
		session.delete(NS+".qnaDeleteAttachByFileName", filename);
	}
	
	/////////////////////////////FAQ//////////////////////////////////
	
	@Override
	public void faqInsert(FaqDTO fdto) {
		
		session.insert(NS+".faqInsert", fdto);
	}
	
	@Override
	public PageTO<FaqDTO> faqList(PageTO<FaqDTO> fto) {
		
		RowBounds rowBounds = new RowBounds(fto.getStartNum() -1, fto.getPerPage());
		
		List<FaqDTO> flist = session.selectList(NS + ".faqList", null, rowBounds);
		
		Integer amount = session.selectOne(NS+".getAmount");
		if (amount != null) {
			fto.setAmount(amount);
		} else {
			fto.setAmount(0);
		}
		
		return fto;
	}
	@Override
	public List<FaqDTO> faqSearchlist(String searchType, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		return session.selectList(NS+".faqSearchlist", map);
	}
	@Override
	public FaqDTO faqRead(int faqNo) {
		
		return session.selectOne(NS+".faqRead", faqNo);
	}
	@Override
	public void faqIncreaseViewcnt(int faqNo) {
		
		session.update(NS+".faqIncreaseViewcnt", faqNo);
	}
	@Override
	public void faqUpdate(FaqDTO fdto) {
		
		session.update(NS+".faqUpdate", fdto);
	}
	@Override
	public void faqDeleteByQnaNo(int faqNo) {
		
		session.delete(NS+".faqDelete", faqNo);
	}
	@Override
	public FaqDTO faqUpdateUI(int faqNo) {
		
		return session.selectOne(NS+".faqUpdateUI", faqNo);
	}
	@Override
	public void faqDelete(int faqNo) {
		
		session.delete(NS+".faqDelete", faqNo);
	}

	
}
