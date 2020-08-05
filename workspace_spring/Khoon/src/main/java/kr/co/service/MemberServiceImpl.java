package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;
import kr.co.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO mDao;

	@Override
	public void insert(MemberDTO mdto) {
		mDao.insert(mdto);
		
	}

	@Override
	public List<MemberDTO> list() {
		return mDao.list();
	}

	@Override
	public MemberDTO read(String id) {
		return mDao.read(id);
	}

	@Override
	public MemberDTO updateui(String id) {
		return mDao.updateui(id);
	}

	@Override
	public void update(MemberDTO dto) {
		mDao.update(dto);
		
	}

	@Override
	public void delete(String id) {
		mDao.delete(id);
		
	}

	@Override
	public MemberDTO loginpost(LoginDTO login) {
		return mDao.loginpost(login);
	}
}
