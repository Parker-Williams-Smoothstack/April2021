/**
 * 
 */
package com.ss.uto.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ss.uto.de.AirplaneType;
import com.ss.uto.utils.ConnectionUtility;

/**
 * @author Parker W.
 *
 */
class AirplaneTypeDAOTest {
	ConnectionUtility conUtil = new ConnectionUtility();
	Connection conn;
	AirplaneTypeDAO tdao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		conn = conUtil.getConnection();
		tdao = new AirplaneTypeDAO(conn);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		conn.close();
	}

	/**
	 * Test method for {@link com.ss.uto.dao.AirplaneTypeDAO#getAll()}.
	 */
	@Test
	void testGetAll() {
		AirplaneType type = new AirplaneType();
		type.setCapacity(100);
		type.setType(1);
		try {
			List<AirplaneType> types = tdao.getAll();
			assertEquals(0, types.size());
			tdao.add(type);
			types = tdao.getAll();
			assertEquals(1, types.size());
			tdao.delete(type);
			types = tdao.getAll();
			assertEquals(0, types.size());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Failed to get all airplane types.");
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.AirplaneTypeDAO#add(com.ss.uto.de.Airplane)}.
	 */
	@Test
	void testAddAirplaneType() {
		AirplaneType type = new AirplaneType();
		type.setCapacity(100);
		type.setType(1);
		try {
			tdao.add(type);
			tdao.delete(type);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Failed to add airplane type.");
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.AirplaneTypeDAO#update(com.ss.uto.de.Airplane)}.
	 */
	@Test
	void testUpdateAirplaneType() {
		AirplaneType type = new AirplaneType();
		type.setType(1);
		type.setCapacity(200);
		try {
			tdao.add(type);
			type.setCapacity(100);
			tdao.update(type);
			tdao.delete(type);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			fail("Failed to update airplane type");
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.AirplaneTypeDAO#delete(com.ss.uto.de.Airplane)}.
	 */
	@Test
	void testDeleteAirplaneType() {
		AirplaneType type = new AirplaneType();
		type.setType(1);
		type.setCapacity(200);
		try {
			tdao.add(type);
			tdao.delete(type);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			fail("Failed to delete airplane type");
		}
	}

}
