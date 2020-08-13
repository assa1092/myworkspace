package kr.co.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.domain.MemberDTO;
import kr.co.domain.PageTO;

public interface MemberService {

    void insert(MemberDTO dto);

	PageTO<MemberDTO> list(PageTO<MemberDTO> mto);

    List<MemberDTO> list();

	MemberDTO read(int memberno);

	void update(MemberDTO to);

	MemberDTO updateUI(int bno);

	void delete(int memberno);

	List<MemberDTO> searchlist(String searchType, String keyword);

	void logout(HttpSession session);

	boolean loginCheck(MemberDTO to, HttpSession session);

	MemberDTO viewMember(MemberDTO to);
	
}
