package kr.co.service;

import java.util.List;

import kr.co.domain.BoardVO;

public interface BoardService {
	void insert(BoardVO vo);	// BoardDAO 에 있는것이라 똑같이 한다...

	List<BoardVO> list();

	BoardVO read(int bno);

	BoardVO updateUI(int bno);

	void update(BoardVO vo);

	void delete(int bno);

	
}
