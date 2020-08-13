package kr.co.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.MemberDTO;
import kr.co.domain.PageTO;

@Repository
public class MemberDAOImpl  implements MemberDAO{

	@Autowired
	private SqlSession session;
	
	
	
	private final String NS = "m.e.m";

	
	  @Override public void insert(MemberDTO dto) {
	  
	  
	  // TODO Auto-generated method stub
	  
	  Integer memberno = session.selectOne(NS + ".getMemberNo"); if (memberno !=
	  null) { memberno += 1; } else { memberno = 1; }
	  
	  dto.setMemberNo(memberno);
	  
	  session.insert(NS+ ".insert", dto); 
	  }
	 

	@Override
	public PageTO<MemberDTO> list(PageTO<MemberDTO> mto) {
    RowBounds rowBounds = new RowBounds(mto.getStartNum()-1, mto.getPerPage());
		
		List<MemberDTO> list = session.selectList(NS + ".list", null, rowBounds);
		
		mto.setList(list);
		
		Integer amount = session.selectOne(NS + ".getAmount");
		if (amount != null) {
			mto.setAmount(amount);
		} else {
			mto.setAmount(0);
		}
		return mto;
	}

	@Override
	public List<MemberDTO> list() {
		// TODO Auto-generated method stub
		return session.selectList(NS + ".list");
	}

	@Override
	public MemberDTO read(int memberno) {
		// TODO Auto-generated method stub
		return session.selectOne(NS+".read", memberno);
	}

	@Override
	public void update(MemberDTO to) {
		// TODO Auto-generated method stub
		session.update(NS + ".update", to);
	}

	@Override
	public MemberDTO updateUI(int memberno) {
		// TODO Auto-generated method stub
		return session.selectOne(NS + ".updateUI", memberno);
	}

	@Override
	public void delete(int memberno) {
		// TODO Auto-generated method stub
		session.delete(NS + ".delete", memberno);
	}

	@Override
	public List<MemberDTO> searchlist(String searchType, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
				
		
		return session.selectList(NS+".searchlist", map);
	}


	@Override
	public boolean loginCheck(MemberDTO to) {
		String name = session.selectOne(NS+".loginCheck", to);
		return (name == null) ? false : true;
	}


	@Override
	public MemberDTO viewMember(MemberDTO to) {
		// TODO Auto-generated method stub
		return session.selectOne(NS+".viewMember", to);
	}


	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		
	}


	}




