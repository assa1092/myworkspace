package kr.co.service;

import java.util.List;

import kr.co.domain.BoardVO;

public interface BoardService {

	void insert(BoardVO vo);

	List<BoardVO> list();

}
