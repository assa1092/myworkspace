package kr.co.persistence;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.domain.MemberDTO;
import kr.co.domain.PageTO;

public interface MemberDAO {

	void insert(MemberDTO dto);

	PageTO<MemberDTO> list(PageTO<MemberDTO> mto);

	List<MemberDTO> list();

	MemberDTO read(int memberno);

	void update(MemberDTO to);

	MemberDTO updateUI(int memberno);

	void delete(int memberno);

	List<MemberDTO> searchlist(String searchType, String keyword);

	boolean loginCheck(MemberDTO to);

	MemberDTO viewMember(MemberDTO to);
	
	void logout(HttpSession session);

}

