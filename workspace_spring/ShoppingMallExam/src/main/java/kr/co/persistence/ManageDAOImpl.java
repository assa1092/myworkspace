package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.FaqDTO;
import kr.co.domain.NoticeDTO;
import kr.co.domain.QnaDTO;
import kr.co.domain.ReviewDTO;

@Repository
public class ManageDAOImpl implements ManageDAO {
	
	@Inject
	private SqlSession session;
	
	private final String NS = "m.a.n";

	@Override
	public List<ReviewDTO> reviewBoardList(List<ReviewDTO> reviewDto) {
		List<ReviewDTO> reviewBoardList = session.selectList(NS+".reviewBoardList");
		return reviewBoardList;
	}

	@Override
	public List<NoticeDTO> noticeBoardList(List<NoticeDTO> noticeDto) {
		List<NoticeDTO> noticeBoardList = session.selectList(NS+".noticeBoardList");
		return noticeBoardList;
	}

	@Override
	public List<FaqDTO> faqBoardList(List<FaqDTO> faqDto) {
		List<FaqDTO> faqBoardList = session.selectList(NS+".faqBoardList");
		return faqBoardList;
	}

	@Override
	public List<QnaDTO> qnaBoardList(List<QnaDTO> qnaDto) {
		List<QnaDTO> qnaBoardList = session.selectList(NS+".qnaBoardList");
		return qnaBoardList;
	}



}