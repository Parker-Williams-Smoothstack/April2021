/**
 * 
 */
package com.ss.uto.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ss.uto.de.UserRole;
import com.ss.uto.utils.ConnectionUtility;

/**
 * @author Parker W.
 *
 */
class UserRoleDAOTest {
	
	ConnectionUtility conUtil = new ConnectionUtility();
	Connection conn;
	UserRoleDAO udao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		conn = conUtil.getConnection();
		udao = new UserRoleDAO(conn);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		conn.close();
	}

	/**
	 * Test method for {@link com.ss.uto.dao.UserRoleDAO#add(com.ss.uto.de.UserRole)}.
	 */
	@Test
	void testAddUserRole() {
		UserRole ur = new UserRole();
		ur.setId(1);
		ur.setName("test user");
		try {
			assertEquals(0, udao.getAll().size());
			udao.add(ur);
			assertEquals(1, udao.getAll().size());
			assertEquals(1, udao.getAll().get(0).getId());
			assertEquals("test user", udao.getAll().get(0).getName());
			udao.delete(ur);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.UserRoleDAO#update(com.ss.uto.de.UserRole)}.
	 */
	@Test
	void testUpdateUserRole() {
		UserRole ur = new UserRole();
		ur.setId(1);
		ur.setName("test user");
		try {
			assertEquals(0, udao.getAll().size());
			udao.add(ur);
			assertEquals(1, udao.getAll().size());
			assertEquals(1, udao.getAll().get(0).getId());
			assertEquals("test user", udao.getAll().get(0).getName());
			ur.setName("new name");
			udao.update(ur);
			assertEquals("new name", udao.getAll().get(0).getName());
			udao.delete(ur);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.UserRoleDAO#delete(com.ss.uto.de.UserRole)}.
	 */
	@Test
	void testDeleteUserRole() {
		UserRole ur = new UserRole();
		ur.setId(1);
		ur.setName("test user");
		try {
			assertEquals(0, udao.getAll().size());
			udao.add(ur);
			assertEquals(1, udao.getAll().size());
			assertEquals(1, udao.getAll().get(0).getId());
			assertEquals("test user", udao.getAll().get(0).getName());
			udao.delete(ur);
			assertEquals(0, udao.getAll().size());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.UserRoleDAO#getAll()}.
	 */
	@Test
	void testGetAll() {
		UserRole ur = new UserRole();
		ur.setId(1);
		ur.setName("test user");
		try {
			assertEquals(0, udao.getAll().size());
			udao.add(ur);
			assertEquals(1, udao.getAll().size());
			assertEquals(1, udao.getAll().get(0).getId());
			assertEquals("test user", udao.getAll().get(0).getName());
			ur.setName("new name");
			udao.update(ur);
			assertEquals("new name", udao.getAll().get(0).getName());
			udao.delete(ur);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			fail();
		}
	}

}
