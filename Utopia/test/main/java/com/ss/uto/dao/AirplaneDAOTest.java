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

import com.ss.uto.de.Airplane;
import com.ss.uto.de.AirplaneType;
import com.ss.uto.utils.ConnectionUtility;

/**
 * @author Parker W.
 *
 */
class AirplaneDAOTest {
	ConnectionUtility conUtil = new ConnectionUtility();
	Connection conn;
	AirplaneDAO adao;
	AirplaneTypeDAO tdao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		conn = conUtil.getConnection();
		adao = new AirplaneDAO(conn);
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
	 * Test method for
	 * {@link com.ss.uto.dao.AirplaneDAO#add(com.ss.uto.de.Airplane)}.
	 */
	@Test
	void testAddAirplane() {
		Airplane plane = new Airplane();
		plane.setId(1);
		AirplaneType type = new AirplaneType();
		type.setType(1);
		type.setCapacity(10);
		plane.setType(type);
		try {
			tdao.add(type);
			adao.add(plane);
			adao.delete(plane);
			tdao.delete(type);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for
	 * {@link com.ss.uto.dao.AirplaneDAO#update(com.ss.uto.de.Airplane)}.
	 */
	@Test
	void testUpdateAirplane() {
		Airplane plane = new Airplane();
		plane.setId(1);

		AirplaneType type = new AirplaneType();
		type.setType(1);
		type.setCapacity(10);

		AirplaneType type2 = new AirplaneType();
		type2.setType(2);
		type2.setCapacity(25);

		plane.setType(type);
		try {
			tdao.add(type);
			adao.add(plane);
			tdao.add(type2);
			plane.setType(type2);
			adao.update(plane);

			adao.delete(plane);
			tdao.delete(type);
			tdao.delete(type2);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for
	 * {@link com.ss.uto.dao.AirplaneDAO#delete(com.ss.uto.de.Airplane)}.
	 */
	@Test
	void testDeleteAirplane() {
		Airplane plane = new Airplane();
		plane.setId(1);
		AirplaneType type = new AirplaneType();
		type.setType(1);
		type.setCapacity(10);
		plane.setType(type);
		try {
			tdao.add(type);
			adao.add(plane);
			adao.delete(plane);
			tdao.delete(type);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.AirplaneDAO#getAll()}.
	 */
	@Test
	void testGetAll() {
		Airplane plane = new Airplane();
		plane.setId(1);
		AirplaneType type = new AirplaneType();
		type.setType(1);
		type.setCapacity(10);
		plane.setType(type);
		try {
			tdao.add(type);
			adao.add(plane);
			assertEquals(1, adao.getAll().size());
			adao.delete(plane);
			tdao.delete(type);
			assertEquals(0, adao.getAll().size());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			fail();
		}
	}

}
