package kr.co.persistence;

import java.util.List;

import kr.co.domain.ReplyVO;

public interface ReplyDAO {

	int insert(ReplyVO vo);
	
	// 일단은 페이징 처리없이...
	// 원글 번호를 알고 댓글을 가져온다..
	List<ReplyVO> list(int bno);

	int update(ReplyVO vo);

	int delete(int rno);

}
