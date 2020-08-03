package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.persistence.BoardDAO;
import kr.co.persistence.ReplyDAO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO bDao;
	@Autowired
	private ReplyDAO rDao;

	@Override
	public void insert(BoardVO vo) {
		bDao.insert(vo);
		
		String[] files = vo.getFiles();
		if (files != null) {
			for(String fullName : files) {
				bDao.addAttach(fullName, vo.getBno());
			}
		}
		
	}

	@Override
	public List<BoardVO> list() {
		return bDao.list();
	}

	@Override
	public PageTO<BoardVO> list(PageTO<BoardVO> to) {
		
		return bDao.list(to);
	}

	@Override
	public BoardVO read(int bno) {
		bDao.increaseViewcnt(bno);
		return bDao.read(bno);
	}

	@Override
	public List<String> getAttach(Integer bno) {
		return bDao.getAttach(bno);
	}

	@Override
	public void deleteAttachByFileName(String filename) {
		bDao.deleteAttachByFileName(filename);
	}

	@Override
	public BoardVO updateUI(int bno) {
		return bDao.updateUI(bno);
	}

	@Override
	public void update(BoardVO vo) {
		bDao.update(vo);
		
		
		bDao.deleteByBno(vo.getBno());
		
		String[] files = vo.getFiles();
		if (files != null) {
			for(String fullName : files) {
				bDao.addAttach(fullName, vo.getBno());
			}
		}
		
	}

	@Override
	public void delete(int bno) {
		rDao.deleteByBno(bno);
		
		bDao.deleteByBno(bno);
		bDao.delete(bno);
		
	}

	@Override
	public List<BoardVO> searchlist(String searchType, String keyword) {
		
		return bDao.searchlist(searchType, keyword);
	}

}
