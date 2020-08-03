package kr.co.persistence;

import java.util.List;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;

public interface BoardDAO {

	void insert(BoardVO vo);

	List<BoardVO> list();

	PageTO<BoardVO> list(PageTO<BoardVO> to);

	BoardVO read(int bno);

	void increaseViewcnt(int bno);

	List<String> getAttach(Integer bno);

	void deleteAttachByFileName(String filename);

	void addAttach(String fullName, int bno);

	BoardVO updateUI(int bno);

	void update(BoardVO vo);

	void deleteByBno(int bno);

	void delete(int bno);

	List<BoardVO> searchlist(String searchType, String keyword);

	

}
