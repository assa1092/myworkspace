package kr.co.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.domain.MemberDTO;
import kr.co.domain.PageTO;
import kr.co.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO mDao;

	
	@Override public void insert(MemberDTO dto) {
		 
		  
	mDao.insert(dto);
		  
}
	 

	@Override
	public PageTO<MemberDTO> list(PageTO<MemberDTO> mto) {
		// TODO Auto-generated method stub
		return mDao.list(mto);
	}

	@Override
	public List<MemberDTO> list() {
		// TODO Auto-generated method stub
		return mDao.list();
	}

	@Override
	public MemberDTO read(int memberno) {
		// TODO Auto-generated method stub
		return mDao.read(memberno);
	}

	@Override
	public void update(MemberDTO to) {
		// TODO Auto-generated method stub
		mDao.update(to);
	}

	@Override
	public MemberDTO updateUI(int memberno) {
		// TODO Auto-generated method stub
		return mDao.updateUI(memberno);
	}

	@Override
	public void delete(int memberno) {
		// TODO Auto-generated method stub
		mDao.delete(memberno);
	}

	@Override
	public List<MemberDTO> searchlist(String searchType, String keyword) {
		// TODO Auto-generated method stub
		return mDao.searchlist(searchType, keyword);
	}


	@Override
	public boolean loginCheck(MemberDTO to, HttpSession session) {
		boolean result = mDao.loginCheck(to);
		if(result) {
			MemberDTO to2 = viewMember(to);
			
			session.setAttribute("memberId", to2.getMemberId());
			session.setAttribute("memberName", to2.getMemberName());
		}
		return result;
	}


	@Override
	public MemberDTO viewMember(MemberDTO to) {
		// TODO Auto-generated method stub
		return mDao.viewMember(to);
	}


	@Override
	public void logout(HttpSession session) {
		
		session.invalidate();
		
	}
	

}