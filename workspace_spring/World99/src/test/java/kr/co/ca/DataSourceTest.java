package kr.co.ca;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)

// @ContextConfiguration(locations = {"file:/src/main/webapp/WEB-INF/spring/root-context.xml"})
// servlet-context.xml, root-context.xml 을 같이 적용하기위해....
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class DataSourceTest {
	@Autowired
	private DataSource dataFactory; //javax.sql.DataSource
	//  bean 객체를 만들기 전에는 null 값이였다...
	//  bean객체 만들고 나서는 하나의 자료형... 
	
	@Test
	public void testConnection() {
		Connection conn = null;
		
		try {
			conn = dataFactory.getConnection();
			System.out.println("==============================");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
