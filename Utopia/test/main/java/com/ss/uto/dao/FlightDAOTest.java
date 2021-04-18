/**
 * 
 */
package com.ss.uto.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ss.uto.de.Airplane;
import com.ss.uto.de.AirplaneType;
import com.ss.uto.de.Airport;
import com.ss.uto.de.Flight;
import com.ss.uto.de.Route;
import com.ss.uto.utils.ConnectionUtility;

/**
 * @author Parker W.
 *
 */
class FlightDAOTest {

	/**
	 * Flight requirements airplane -> airplane_type route -> airport(2)
	 */

	ConnectionUtility conUtil = new ConnectionUtility();
	Connection conn;
	FlightDAO fdao;

	AirplaneType type = new AirplaneType();
	Airplane plane = new Airplane();
	Route route = new Route();
	Airport port1 = new Airport();
	Airport port2 = new Airport();

	/**
	 * @throws java.lang.Exception Added test values to tables
	 */
	@BeforeEach
	void setUp() throws Exception {
		conn = conUtil.getConnection();

		port1.setCityName("Airport city one");
		port1.setCode("PCO");
		port2.setCityName("Airport city two");
		port2.setCode("PCT");

		route.setId(1);
		route.setDestination(port2);
		route.setOrigin(port1);

		type.setCapacity(100);
		type.setType(1);

		plane.setId(1);
		plane.setType(type);

		AirportDAO pdao = new AirportDAO(conn);
		pdao.add(port1);
		pdao.add(port2);

		RouteDAO rdao = new RouteDAO(conn);
		rdao.add(route);

		AirplaneTypeDAO tdao = new AirplaneTypeDAO(conn);
		tdao.add(type);

		AirplaneDAO adao = new AirplaneDAO(conn);
		adao.add(plane);

		fdao = new FlightDAO(conn);

	}

	/**
	 * @throws java.lang.Exception Remove test values from tables
	 */
	@AfterEach
	void tearDown() throws Exception {
		AirplaneDAO adao = new AirplaneDAO(conn);
		adao.delete(plane);

		AirplaneTypeDAO tdao = new AirplaneTypeDAO(conn);
		tdao.delete(type);

		RouteDAO rdao = new RouteDAO(conn);
		rdao.delete(route);

		AirportDAO pdao = new AirportDAO(conn);
		pdao.delete(port1);
		pdao.delete(port2);

		conn.close();
	}

	/**
	 * Test method for {@link com.ss.uto.dao.FlightDAO#add(com.ss.uto.de.Flight)}.
	 */
	@Test
	void testAddFlight() {
		Flight f = new Flight();
		Date date = new Date(System.currentTimeMillis());
		f.setId(1);
		f.setDepatureTime(date);
		f.setReservedSeats(25);
		f.setSeatPrice(10f);
		f.setRoute(route);
		f.setPlane(plane);

		try {
			assertEquals(0, fdao.getAll().size());
			fdao.add(f);
			assertEquals(1, fdao.getAll().size());

			fdao.delete(f);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Failed to add flight");
		}
	}

	/**
	 * Test method for
	 * {@link com.ss.uto.dao.FlightDAO#update(com.ss.uto.de.Flight)}.
	 */
	@Test
	void testUpdateFlight() {
		Flight f = new Flight();
		Date date = new Date(System.currentTimeMillis());
		f.setId(1);
		f.setDepatureTime(date);
		f.setReservedSeats(25);
		f.setSeatPrice(10f);
		f.setRoute(route);
		f.setPlane(plane);
		
		try {
			fdao.add(f);
			f.setReservedSeats(20);
			assertEquals(25, fdao.getAll().get(0).getReservedSeats());
			fdao.update(f);
			assertEquals(20, fdao.getAll().get(0).getReservedSeats());
			
			fdao.delete(f);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for
	 * {@link com.ss.uto.dao.FlightDAO#delete(com.ss.uto.de.Flight)}.
	 */
	@Test
	void testDeleteFlight() {
		Flight f = new Flight();
		Date date = new Date(System.currentTimeMillis());
		f.setId(1);
		f.setDepatureTime(date);
		f.setReservedSeats(25);
		f.setSeatPrice(10f);
		f.setRoute(route);
		f.setPlane(plane);
		
		try {
			fdao.add(f);
			assertEquals(1, fdao.getAll().size());
			fdao.delete(f);
			assertEquals(0, fdao.getAll().size());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.FlightDAO#getAll()}.
	 */
	@Test
	void testGetAll() {
		Flight f = new Flight();
		Date date = new Date(System.currentTimeMillis());
		f.setId(1);
		f.setDepatureTime(date);
		f.setReservedSeats(25);
		f.setSeatPrice(10f);
		f.setRoute(route);
		f.setPlane(plane);
		
		try {
			assertEquals(0, fdao.getAll().size());
			fdao.add(f);
			assertEquals(1, fdao.getAll().size());
			fdao.delete(f);
			assertEquals(0, fdao.getAll().size());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

}
