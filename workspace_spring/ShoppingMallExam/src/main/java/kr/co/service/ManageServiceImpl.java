package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.FaqDTO;
import kr.co.domain.NoticeDTO;
import kr.co.domain.QnaDTO;
import kr.co.domain.ReviewDTO;
import kr.co.persistence.ManageDAO;

@Service
public class ManageServiceImpl implements ManageService {
	
	@Inject
	private ManageDAO manageDao;

	@Override
	public List<ReviewDTO> reviewBoardList(List<ReviewDTO> reviewDto) {
		return manageDao.reviewBoardList(reviewDto);
	}

	@Override
	public List<NoticeDTO> noticeBoardList(List<NoticeDTO> noticeDto) {
		return manageDao.noticeBoardList(noticeDto);
	}

	@Override
	public List<FaqDTO> faqBoardList(List<FaqDTO> faqDto) {
		return manageDao.faqBoardList(faqDto);
	}

	@Override
	public List<QnaDTO> qnaBoardList(List<QnaDTO> qnaDto) {
		return manageDao.qnaBoardList(qnaDto);
	}




}