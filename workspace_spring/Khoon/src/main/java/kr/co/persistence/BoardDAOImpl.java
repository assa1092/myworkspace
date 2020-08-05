package kr.co.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession session;
	
	private final String  NS = "b.o.a";

	@Override
	public void insert(BoardVO vo) {
		
		Integer bno = session.selectOne(NS+".getBno");
		if (bno != null) {
			bno +=1;
		} else {
			bno = 1;
		}
		
		vo.setBno(bno);
		
		session.insert(NS+".insert", vo);
	}

	@Override
	public List<BoardVO> list() {
		return session.selectList(NS+".list");
	}
}
