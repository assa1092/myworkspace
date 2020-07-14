package kr.co.ca;



import javax.inject.Inject;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)

// @ContextConfiguration(locations = {"file:/src/main/webapp/WEB-INF/spring/root-context.xml"})
// servlet-context.xml, root-context.xml 을 같이 적용하기위해....
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class MybatisTest {
	@Inject
	private SqlSessionFactory sqlFactory; 
	//  bean 객체를 만들기 전에는 null 값이였다...
	//  bean객체 만들고 나서는 하나의 자료형... 
	
	@Test
	public void testSession() {
		SqlSession session = null;
		
		try {
			session = sqlFactory.openSession();
			System.out.println("==============================");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
