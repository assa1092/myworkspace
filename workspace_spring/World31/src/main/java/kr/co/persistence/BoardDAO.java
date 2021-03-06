package kr.co.persistence;

import java.util.List;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;

public interface BoardDAO {
	
	void insert(BoardVO vo);
	
	// 업로드한 파일 저장...
	void addAttach(String fullName, int bno);
	

	List<BoardVO> list();

	BoardVO read(int bno);

	void increaseViewcnt(int bno);

	BoardVO updateUI(int bno);

	void update(BoardVO vo);

	void delete(int bno);

	PageTO<BoardVO> list(PageTO<BoardVO> to);

	List<BoardVO> searchlist(String searchType, String keyword);

	List<String> getAttach(Integer bno);

	void updateAttach(String fullName, int bno);

	void deleteAttachByFileName(String filename);

	void deleteByBno(int bno);

	
}
