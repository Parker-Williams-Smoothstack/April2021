/**
 * 
 */
package com.ss.uto.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Parker W.
 *
 */
class ConnectionUtilityTest {

	/**
	 * Test method for {@link com.ss.uto.utils.ConnectionUtility#getConnection()}.
	 */
	@Test
	void testGetConnection() {
		Connection conn = null;
		ConnectionUtility conUtil = new ConnectionUtility();
		assertNotNull(conUtil);
		try {
			conn = conUtil.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Failed to connect to the server.");
		}
		assertNotNull(conn);
	}

}
