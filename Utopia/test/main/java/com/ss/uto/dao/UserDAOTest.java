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

import com.ss.uto.de.User;
import com.ss.uto.de.UserRole;
import com.ss.uto.utils.ConnectionUtility;

/**
 * @author Parker W.
 *
 */
class UserDAOTest {
	
	ConnectionUtility conUtil = new ConnectionUtility();
	Connection conn;
	UserDAO udao;
	UserRole r1 = new UserRole();
	UserRole r2 = new UserRole();
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {		
		conn = conUtil.getConnection();
		udao = new UserDAO(conn);
		r1.setId(1);
		r1.setName("Admin");
		r2.setId(2);
		r2.setName("Guest");
		UserRoleDAO urdao = new UserRoleDAO(conn);
		urdao.add(r1);
		urdao.add(r2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		UserRoleDAO urdao = new UserRoleDAO(conn);
		urdao.delete(r1);
		urdao.delete(r2);
		conn.close();
	}

	/**
	 * Test method for {@link com.ss.uto.dao.UserDAO#add(com.ss.uto.de.User)}.
	 */
	@Test
	void testAddUser() {
		User u = new User();

		u.setId(1);
		u.setEmail("email");
		u.setFamilyName("family name");
		u.setGivenName("given name");
		u.setUsername("username");
		u.setPassword("password");
		u.setPhone("56709");
		u.setRole(r1);
		try {
			assertEquals(0, udao.getAll().size());
			udao.add(u);
			assertEquals(1, udao.getAll().size());
			assertEquals("email", udao.getAll().get(0).getEmail());
			assertEquals("family name", udao.getAll().get(0).getFamilyName());
			assertEquals("given name", udao.getAll().get(0).getGivenName());
			assertEquals("username", udao.getAll().get(0).getUsername());
			assertEquals("password", udao.getAll().get(0).getPassword());
			assertEquals("56709", udao.getAll().get(0).getPhone());
			assertEquals(r1, udao.getAll().get(0).getRole());
			udao.delete(u);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.UserDAO#update(com.ss.uto.de.User)}.
	 */
	@Test
	void testUpdateUser() {
		User u = new User();

		u.setId(1);
		u.setEmail("email");
		u.setFamilyName("family name");
		u.setGivenName("given name");
		u.setUsername("username");
		u.setPassword("password");
		u.setPhone("56709");
		u.setRole(r1);
		try {
			assertEquals(0, udao.getAll().size());
			udao.add(u);
			assertEquals(1, udao.getAll().size());
			assertEquals("email", udao.getAll().get(0).getEmail());
			assertEquals("family name", udao.getAll().get(0).getFamilyName());
			assertEquals("given name", udao.getAll().get(0).getGivenName());
			assertEquals("username", udao.getAll().get(0).getUsername());
			assertEquals("password", udao.getAll().get(0).getPassword());
			assertEquals("56709", udao.getAll().get(0).getPhone());
			assertEquals(r1, udao.getAll().get(0).getRole());
			
			u.setRole(r2);
			u.setPassword("new password");
			udao.update(u);
			assertEquals(1, udao.getAll().size());
			assertEquals("email", udao.getAll().get(0).getEmail());
			assertEquals("family name", udao.getAll().get(0).getFamilyName());
			assertEquals("given name", udao.getAll().get(0).getGivenName());
			assertEquals("username", udao.getAll().get(0).getUsername());
			assertEquals("new password", udao.getAll().get(0).getPassword());
			assertEquals("56709", udao.getAll().get(0).getPhone());
			assertEquals(r2, udao.getAll().get(0).getRole());
			
			udao.delete(u);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.UserDAO#delete(com.ss.uto.de.User)}.
	 */
	@Test
	void testDeleteUser() {
		User u = new User();

		u.setId(1);
		u.setEmail("email");
		u.setFamilyName("family name");
		u.setGivenName("given name");
		u.setUsername("username");
		u.setPassword("password");
		u.setPhone("56709");
		u.setRole(r1);
		try {
			assertEquals(0, udao.getAll().size());
			udao.add(u);
			assertEquals(1, udao.getAll().size());
			assertEquals("email", udao.getAll().get(0).getEmail());
			assertEquals("family name", udao.getAll().get(0).getFamilyName());
			assertEquals("given name", udao.getAll().get(0).getGivenName());
			assertEquals("username", udao.getAll().get(0).getUsername());
			assertEquals("password", udao.getAll().get(0).getPassword());
			assertEquals("56709", udao.getAll().get(0).getPhone());
			assertEquals(r1, udao.getAll().get(0).getRole());
			
			u.setRole(r2);
			u.setPassword("new password");
			udao.update(u);
			assertEquals(1, udao.getAll().size());
			assertEquals("email", udao.getAll().get(0).getEmail());
			assertEquals("family name", udao.getAll().get(0).getFamilyName());
			assertEquals("given name", udao.getAll().get(0).getGivenName());
			assertEquals("username", udao.getAll().get(0).getUsername());
			assertEquals("new password", udao.getAll().get(0).getPassword());
			assertEquals("56709", udao.getAll().get(0).getPhone());
			assertEquals(r2, udao.getAll().get(0).getRole());
			
			udao.delete(u);
			assertEquals(0, udao.getAll().size());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.UserDAO#getAll()}.
	 */
	@Test
	void testGetAll() {
		User u = new User();

		u.setId(1);
		u.setEmail("email");
		u.setFamilyName("family name");
		u.setGivenName("given name");
		u.setUsername("username");
		u.setPassword("password");
		u.setPhone("56709");
		u.setRole(r1);
		try {
			assertEquals(0, udao.getAll().size());
			udao.add(u);
			assertEquals(1, udao.getAll().size());
			assertEquals("email", udao.getAll().get(0).getEmail());
			assertEquals("family name", udao.getAll().get(0).getFamilyName());
			assertEquals("given name", udao.getAll().get(0).getGivenName());
			assertEquals("username", udao.getAll().get(0).getUsername());
			assertEquals("password", udao.getAll().get(0).getPassword());
			assertEquals("56709", udao.getAll().get(0).getPhone());
			assertEquals(r1, udao.getAll().get(0).getRole());
			
			u.setRole(r2);
			u.setPassword("new password");
			udao.update(u);
			assertEquals(1, udao.getAll().size());
			assertEquals("email", udao.getAll().get(0).getEmail());
			assertEquals("family name", udao.getAll().get(0).getFamilyName());
			assertEquals("given name", udao.getAll().get(0).getGivenName());
			assertEquals("username", udao.getAll().get(0).getUsername());
			assertEquals("new password", udao.getAll().get(0).getPassword());
			assertEquals("56709", udao.getAll().get(0).getPhone());
			assertEquals(r2, udao.getAll().get(0).getRole());
			
			udao.delete(u);
			assertEquals(0, udao.getAll().size());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

}
