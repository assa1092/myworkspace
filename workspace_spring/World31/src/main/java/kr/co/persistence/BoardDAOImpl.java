package kr.co.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	
	// NameSpace
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
	public List<BoardVO> searchlist(String searchType, String keyword) {
		
		// SearchTO 클래스를 만들거나....Map이용...
		
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		
		return session.selectList(NS+".searchlist", map);	
		// 페이징 처리 하려면 rowBounds까지 가져가야한다..
	}

	@Override
	public void addAttach(String fullName, int bno) {
		
		Integer id = session.selectOne(NS + ".getId");
	
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", id);
		map.put("fullName", fullName);
		map.put("bno", bno);
		
		// 보낼 파라미터는 1개, 보내야 할 파라미터는 2개 이상이면 Map 을 이용해서 보낸다.
		// DAO를 생성해서 객체 만들어서 보낼수도 있지만....
		// 자주 쓰는것이 아니고 일시적인것이면 무조건 Map
		session.insert(NS+".addAttach", map);
		
	}

	@Override
	public List<String> getAttach(Integer bno) {
		
		return session.selectList(NS+".getAttach", bno);
	}

	@Override
	public void updateAttach(String fullName, int bno) {
		
		Integer id = session.selectOne(NS + ".getId");
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", id);
		map.put("fullName", fullName);
		map.put("bno", bno);
		
		session.update(NS+".updateAttach", map);
		
	}

	@Override
	public void deleteAttachByFileName(String filename) {
		session.delete(NS+".deleteAttachByFileName", filename);
		
	}

	@Override
	public void deleteByBno(int bno) {
		session.delete(NS+".deleteByBno", bno);
		
	}

	
}
