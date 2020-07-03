package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	
	private final String NS = "b.o.a";

	@Override
	public void insert(BoardVO vo) {
		
		// 게시판의 bno를 가져와야 한다...
		Integer bno = session.selectOne(NS+".getBno");
		if(bno != null) {	// bno가 null 아닐경우가 많기때문에 이렇게 해야 else는 딱 한번만 실행된다.	
			bno += 1;
		} else{
			bno =1;
		}
				// Service 페이지에서 처리 할수도있음...
		vo.setBno(bno); 	// 게시판 글 번호 알아왔으니 그 번호 다시 세팅...
		
		
		session.insert(NS + ".insert", vo);
	}

	@Override
	public List<BoardVO> list() {
		
		return session.selectList(NS + ".list");
	}

	@Override
	public BoardVO read(int bno) {
		
		return session.selectOne(NS + ".read", bno);
	}

	@Override
	public void increaseViewcnt(int bno) {
		
		session.update(NS + ".increaseViewcnt", bno );
		
	}

	@Override
	public BoardVO updateUI(int bno) {
		return session.selectOne(NS+".updateUI", bno);
	}

	@Override
	public void update(BoardVO vo) {
		session.update(NS + ".update", vo);
	}

	@Override
	public void delete(int bno) {
		session.delete(NS + ".delete", bno);
	}

	
}
