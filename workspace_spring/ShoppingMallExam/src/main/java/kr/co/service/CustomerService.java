package kr.co.service;

import java.util.List;

import kr.co.domain.FaqDTO;
import kr.co.domain.PageTO;
import kr.co.domain.QnaDTO;

public interface CustomerService {
	//////////////////////////////Q&A/////////////////////////////////
	void qnaInsert(QnaDTO qdto);

	PageTO<QnaDTO> qnaList(PageTO<QnaDTO> qto);

	QnaDTO qnaRead(int qnaNo);

	QnaDTO qnaUpdateUI(int qnaNo);

	void qnaUpdate(QnaDTO qdto);

	void qnaDelete(int qnaNo);

	List<QnaDTO> qnaSearchlist(String searchType, String keyword);
	
	List<String> getQnaAttach(Integer qnaNo);
	
	void qnaDeleteAttachByFileName(String filename);
	
	//////////////////////////////FAQ/////////////////////////////////

	void faqInsert(FaqDTO fdto);

	PageTO<FaqDTO> faqList(PageTO<FaqDTO> fto);

	List<FaqDTO> faqSearchlist(String searchType, String keyword);

	FaqDTO faqRead(int faqNo);

	void faqUpdate(FaqDTO fdto);

	FaqDTO faqUpdateUI(int faqNo);

	void faqDelete(int faqNo);

}
