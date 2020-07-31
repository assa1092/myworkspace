package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Inject
	private SqlSession session;
	
	private final String NS = "b.o.a";

	@Override
	public void insert(BoardVO vo) {
		
		
		Integer bno = session.selectOne(NS+".getBno");
		if (bno != null) {
			bno += 1;
		} else {
			bno =1;
		}
		
		vo.setBno(bno);
		
		
		session.insert(NS+".insert", vo);
		
	}

	@Override
	public List<BoardVO> list() {
		
		return session.selectList(NS+".list");
	}

	@Override
	public PageTO<BoardVO> list(PageTO<BoardVO> to) {
		// session.selectLit의 반환형이 List라 그냥 쓰면 안된다...

		// new RowBounds(int offset, int limit)
		// (offset 어디서,  limit 얼마만큼)
		// oracle 은 인덱스 1부터 시작...
		// mybatis 는 인덱스가 0부터 시작
		// 그래서 to.getStartNum()에서 -1 을 해 주어야한다...
		// -1 을 안하면 젤 마지막에것이 안나온다...
		
		// rowBounds 를 쓰지 않으면 Mapper 까지도 바꾸어 주어야한다... 
		RowBounds rowBounds = new RowBounds(to.getStartNum()-1, to.getPerPage());
		
		// 두번째 파라미터는 검색어 입력할때...그때 들어간다...지금은 null
		List<BoardVO> list = session.selectList(NS+".list", null, rowBounds);
		
		// PageTO 객체의 list가 비어있기때문에....
		// 값을 넣어주어야한다...
		to.setList(list);
		
		// 글 총 개수 가져와서 페이지처리하기.. 없으면 0.
		Integer amount = session.selectOne(NS+".getAmount");
		if (amount != null) {
			to.setAmount(amount);
		} else {
			to.setAmount(0);
		}
		
		
		return to;
	}

	@Override
	public BoardVO read(int bno) {
		return session.selectOne(NS+".read", bno);
		
	}

	@Override
	public void increaseViewcnt(int bno) {
		session.update(NS+".increaseViewcnt", bno );
		
	}

}
