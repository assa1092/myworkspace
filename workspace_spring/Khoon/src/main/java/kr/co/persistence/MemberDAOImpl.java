package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession session;
	
	private final String NS = "m.e.m";

	@Override
	public void insert(MemberDTO mdto) {
		session.insert(NS+".insert", mdto);
		
		
	}

	@Override
	public List<MemberDTO> list() {
		return session.selectList(NS+".list");
	}

	@Override
	public MemberDTO read(String id) {
		return session.selectOne(NS+".read", id);
	}

	@Override
	public MemberDTO updateui(String id) {
		return session.selectOne(NS+".updateui", id);
	}

	@Override
	public void update(MemberDTO dto) {
		session.update(NS+".update", dto);
		
	}

	@Override
	public void delete(String id) {
		session.delete(NS+".delete", id);
		
	}

	@Override
	public MemberDTO loginpost(LoginDTO login) {
		return session.selectOne(NS+".loginpost", login);
	}
}
