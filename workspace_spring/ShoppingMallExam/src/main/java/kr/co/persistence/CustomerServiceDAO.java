package kr.co.persistence;

import java.util.List;

import kr.co.domain.FaqDTO;
import kr.co.domain.PageTO;
import kr.co.domain.QnaDTO;

public interface CustomerServiceDAO {
	////////////////////////////Q&A//////////////////////////////////
	void qnaInsert(QnaDTO qdto);

	void qnaAddAttach(String fullName, int qnaNo);
	
	void qnaUpdateAttach(String fullName, int qnaNo);
	
	List<QnaDTO> qnaList();

	QnaDTO qnaRead(int qnaNo);
	
	void qnaIncreaseViewcnt(int qnaNo);

	QnaDTO qnaUpdateUi(int qnaNo);

	void qnaUpdate(QnaDTO qdto);

	void qnaDelete(int qnaNo);

	PageTO<QnaDTO> qnaList(PageTO<QnaDTO> qto);

	List<QnaDTO> qnaSearchlist(String searchType, String keyword);

	List<String> getQnaattach(Integer qnaNo);

	void qnaDeleteAttachByFileName(String filename);

	void qnaDeleteByQnaNo(int qnaNo);
	
	////////////////////////////FAQ//////////////////////////////////

	void faqInsert(FaqDTO fdto);

	PageTO<FaqDTO> faqList(PageTO<FaqDTO> fto);

	List<FaqDTO> faqSearchlist(String searchType, String keyword);

	FaqDTO faqRead(int faqNo);

	void faqIncreaseViewcnt(int faqNo);

	void faqUpdate(FaqDTO fdto);

	void faqDeleteByQnaNo(int faqNo);

	FaqDTO faqUpdateUI(int faqNo);

	void faqDelete(int faqNo);

}
