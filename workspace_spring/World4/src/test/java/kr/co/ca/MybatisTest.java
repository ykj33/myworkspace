package kr.co.ca;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// 폴더가 있을 수도 있고 없을 수도 있다 = **
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MybatisTest {
	// spring container가 관리하는 객체들 = bean을 자료형을 보고 넣어준다.
	@Inject
	private SqlSessionFactory sqlFactory;

	// 테스트 객체
	// 무조건 public void, 앞에는 관용적으로 test, 파라미터 X
	@Test
	public void testSession() {
		SqlSession session = null;
		try {
			session = sqlFactory.openSession();
			System.out.println("===================");
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
