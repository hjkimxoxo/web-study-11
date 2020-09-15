package web_study_11.ds;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;


public class JdbcUtilTest {

	@Test
	public void testGetConnection() {
		System.out.println("TestGetConnection");
		Connection con = JndiDS.getConnection();
		Assert.assertNotNull(con);
		System.out.println(con);
	}

}
