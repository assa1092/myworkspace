package kr.co.service;

import java.util.List;

import kr.co.domain.QnaAttachDTO;

public interface QnaAttachService {

	List<QnaAttachDTO> list(int qnaNo);
	
	int insert(QnaAttachDTO qadto);
	
	int update(QnaAttachDTO qadto);
	
	int delete(QnaAttachDTO qadto);
}
