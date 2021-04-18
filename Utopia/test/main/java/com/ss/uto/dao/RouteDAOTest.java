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
import com.ss.uto.de.Route;
import com.ss.uto.utils.ConnectionUtility;

/**
 * @author Parker W.
 *
 */
class RouteDAOTest {
	
	ConnectionUtility conUtil = new ConnectionUtility();
	Connection conn;
	RouteDAO rdao;
	AirportDAO pdao;
	Airport port1 = new Airport();
	Airport port2 = new Airport();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		conn = conUtil.getConnection();
		rdao = new RouteDAO(conn);
		pdao = new AirportDAO(conn);
		
		port1.setCode("PTO");
		port2.setCode("PTT");
		port1.setCityName("Port Title One");
		port2.setCityName("Port Title Two");
		pdao.add(port1);
		pdao.add(port2);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		pdao.delete(port1);
		pdao.delete(port2);
		conn.close();
	}

	/**
	 * Test method for {@link com.ss.uto.dao.RouteDAO#add(com.ss.uto.de.Route)}.
	 */
	@Test
	void testAddRoute() {
		Route r = new Route();
		r.setDestination(port1);
		r.setId(1);
		r.setOrigin(port2);
		try {
			assertEquals(0, rdao.getAll().size());
			rdao.add(r);
			assertEquals(1, rdao.getAll().size());
			
			rdao.delete(r);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.RouteDAO#update(com.ss.uto.de.Route)}.
	 */
	@Test
	void testUpdateRoute() {
		Route r = new Route();
		r.setDestination(port1);
		r.setId(1);
		r.setOrigin(port2);
		try {
			assertEquals(0, rdao.getAll().size());
			rdao.add(r);
			assertEquals(1, rdao.getAll().size());
			assertEquals(port2, rdao.getAll().get(0).getOrigin());
			assertEquals(port1, rdao.getAll().get(0).getDestination());
			assertEquals(1, rdao.getAll().get(0).getId());
			
			r.setOrigin(port1);
			r.setDestination(port2);
			rdao.update(r);
			
			assertEquals(1, rdao.getAll().size());
			assertEquals(port1, rdao.getAll().get(0).getOrigin());
			assertEquals(port2, rdao.getAll().get(0).getDestination());
			assertEquals(1, rdao.getAll().get(0).getId());
			
			rdao.delete(r);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.RouteDAO#delete(com.ss.uto.de.Route)}.
	 */
	@Test
	void testDeleteRoute() {
		Route r = new Route();
		r.setDestination(port1);
		r.setId(1);
		r.setOrigin(port2);
		try {
			assertEquals(0, rdao.getAll().size());
			rdao.add(r);
			assertEquals(1, rdao.getAll().size());
			
			rdao.delete(r);
			assertEquals(0, rdao.getAll().size());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.RouteDAO#getAll()}.
	 */
	@Test
	void testGetAll() {
		Route r = new Route();
		r.setDestination(port1);
		r.setId(1);
		r.setOrigin(port2);
		try {
			assertEquals(0, rdao.getAll().size());
			rdao.add(r);
			assertEquals(1, rdao.getAll().size());
			assertEquals(port2, rdao.getAll().get(0).getOrigin());
			assertEquals(port1, rdao.getAll().get(0).getDestination());
			assertEquals(1, rdao.getAll().get(0).getId());
			
			r.setOrigin(port1);
			r.setDestination(port2);
			rdao.update(r);
			
			assertEquals(1, rdao.getAll().size());
			assertEquals(port1, rdao.getAll().get(0).getOrigin());
			assertEquals(port2, rdao.getAll().get(0).getDestination());
			assertEquals(1, rdao.getAll().get(0).getId());
			
			rdao.delete(r);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

}
