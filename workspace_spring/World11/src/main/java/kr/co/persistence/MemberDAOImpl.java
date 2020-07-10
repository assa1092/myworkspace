package kr.co.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.MemberDTO;

@Repository		// 객체를 만들겠다는 표시....@
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession session;	//	root-context.xml 에 정의된것 호출하는것....
	
	private final String NS = "m.e.m";
	
	@Override
	public void insert(MemberDTO dto) {
		session.insert( NS+".insert", dto);	
		// memberMapper.xml 에 붙여둔 namespacea 이름...
		// 해당 네임스페이스의 id값을 찾아서 실행
		
	}

	@Override
	public List<MemberDTO> list() {
		return session.selectList(NS+".list");
	}

	@Override
	public MemberDTO read(String id) {
				// .read => Mapper.xml의 아이디....
		return session.selectOne(NS + ".read", id);
		
	}

	@Override
	public MemberDTO updateui(String id) {
		// 데이터를 가져와야하기때문에 updateui
		return session.selectOne(NS + ".updateui", id);
	}

	@Override
	public void update(MemberDTO dto) {
		session.update(NS + ".update", dto);
		
	}

	@Override
	public void delete(String id) {
		session.delete(NS + ".delete", id);
		
	}
	
}
