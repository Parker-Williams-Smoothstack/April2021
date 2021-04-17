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

import com.ss.uto.de.Airport;
import com.ss.uto.utils.ConnectionUtility;

/**
 * @author Parker W.
 *
 */
class AirportDAOTest {
	ConnectionUtility conUtil = new ConnectionUtility();
	Connection conn;
	AirportDAO adao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		conn = conUtil.getConnection();
		adao = new AirportDAO(conn);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		conn.close();
	}

	/**
	 * Test method for {@link com.ss.uto.dao.AirportDAO#add(com.ss.uto.de.Airport)}.
	 */
	@Test
	void testAddAirport() {
		Airport port = new Airport();
		port.setCode("ABC");
		port.setCityName("CITY NUMBER ONE");
		try {
			assertEquals(0, adao.getAll().size());
			adao.add(port);
			assertEquals(1, adao.getAll().size());
			assertEquals("ABC", adao.getAll().get(0).getCode());
			assertEquals("CITY NUMBER ONE", adao.getAll().get(0).getCityName());
			adao.delete(port);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.AirportDAO#update(com.ss.uto.de.Airport)}.
	 */
	@Test
	void testUpdateAirport() {
		Airport port = new Airport();
		port.setCode("ABC");
		port.setCityName("CITY NUMBER ONE");
		try {
			adao.add(port);
			assertEquals(1, adao.getAll().size());
			assertEquals("ABC", adao.getAll().get(0).getCode());
			assertEquals("CITY NUMBER ONE", adao.getAll().get(0).getCityName());
			port.setCityName("City one");
			adao.update(port);
			assertEquals("ABC", adao.getAll().get(0).getCode());
			assertEquals("City one", adao.getAll().get(0).getCityName());
			adao.delete(port);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.AirportDAO#delete(com.ss.uto.de.Airport)}.
	 */
	@Test
	void testDeleteAirport() {
		Airport port = new Airport();
		port.setCode("ABC");
		port.setCityName("CITY NUMBER ONE");
		try {
			adao.add(port);
			assertEquals(1, adao.getAll().size());
			adao.delete(port);
			assertEquals(0, adao.getAll().size());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.AirportDAO#getAll()}.
	 */
	@Test
	void testGetAll() {
		Airport port = new Airport();
		port.setCode("ABC");
		port.setCityName("CITY NUMBER ONE");
		try {
			adao.add(port);
			assertEquals(1, adao.getAll().size());
			adao.delete(port);
			assertEquals(0, adao.getAll().size());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
