package kr.co.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.ManagerDTO;

@Repository
public class ManagerDAOImpl implements ManagerDAO{
	@Autowired
	private SqlSession session;
	
	private final String NS = "m.a.n";

	@Override
	public void insert(ManagerDTO dto) {
		session.insert(NS + ".insert", dto);
		
	}

}
