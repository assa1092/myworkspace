package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import kr.co.domain.QnaAttachDTO;

public class QnaAttahDAOImple implements QnaAttahDAO{

	@Inject
	private SqlSession session;
	
	private final String NS = "q.n.a";
	
	@Override
	public List<QnaAttachDTO> list(int qnaNo) {
		
		return session.selectList(NS+".list", qnaNo);
	}

	@Override
	public int insert(QnaAttachDTO qadto) {

		return session.insert(NS+".insert", qadto);
	}

	@Override
	public int update(QnaAttachDTO qadto) {
		
		return session.update(NS+".update", qadto);
	}

	@Override
	public int delete(QnaAttachDTO qadto) {
		
		return session.delete(NS+".delete", qadto);
	}
	
	@Override
	public void deleteByQnaNo(int qnaNo) {
		session.delete(NS+".deleteByQnaNo", qnaNo);
	}

}
