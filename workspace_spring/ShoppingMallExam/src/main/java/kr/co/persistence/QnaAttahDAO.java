package kr.co.persistence;

import java.util.List;

import kr.co.domain.QnaAttachDTO;

public interface QnaAttahDAO {

	List<QnaAttachDTO> list(int qnaNo);

	int insert(QnaAttachDTO qadto);

	int update(QnaAttachDTO qadto);

	int delete(QnaAttachDTO qadto);

	void deleteByQnaNo(int qnaNo);

}
