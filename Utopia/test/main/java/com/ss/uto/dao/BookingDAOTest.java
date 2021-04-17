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

import com.ss.uto.de.Booking;
import com.ss.uto.utils.ConnectionUtility;

/**
 * @author Parker W.
 *
 */
class BookingDAOTest {
	ConnectionUtility conUtil = new ConnectionUtility();
	Connection conn;
	BookingDAO bdao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		conn = conUtil.getConnection();
		bdao = new BookingDAO(conn);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		conn.close();
	}

	/**
	 * Test method for {@link com.ss.uto.dao.BookingDAO#add(com.ss.uto.de.Booking)}.
	 */
	@Test
	void testAddBooking() {
		Booking b = new Booking();
		b.setActive(true);
		b.setConfirmationCode("confirmCode725");
		b.setId(725);
		try {
			assertEquals(0,  bdao.getAll().size());
			bdao.add(b);
			assertEquals(1, bdao.getAll().size());
			assertEquals(725, bdao.getAll().get(0).getId());
			assertTrue(bdao.getAll().get(0).isActive());
			assertEquals("confirmCode725", bdao.getAll().get(0).getConfirmationCode());
			bdao.delete(b);
			assertEquals(0, bdao.getAll().size());
		} catch (ClassNotFoundException | SQLException e) {
			fail();
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.BookingDAO#update(com.ss.uto.de.Booking)}.
	 */
	@Test
	void testUpdateBooking() {
		Booking b = new Booking();
		b.setActive(true);
		b.setConfirmationCode("confirmCode725");
		b.setId(725);
		try {
			bdao.add(b);
			b.setConfirmationCode("new code");
			bdao.update(b);
			assertEquals("new code", bdao.getAll().get(0).getConfirmationCode());
			b.setActive(false);
			bdao.update(b);
			assertFalse(bdao.getAll().get(0).isActive());
			bdao.delete(b);
			assertEquals(0, bdao.getAll().size());
		} catch (ClassNotFoundException | SQLException e) {
			fail();
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.BookingDAO#delete(com.ss.uto.de.Booking)}.
	 */
	@Test
	void testDeleteBooking() {
		Booking b = new Booking();
		b.setActive(true);
		b.setConfirmationCode("confirmCode725");
		b.setId(725);
		try {
			bdao.add(b);
			bdao.delete(b);
			assertEquals(0, bdao.getAll().size());
		} catch (ClassNotFoundException | SQLException e) {
			fail();
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.ss.uto.dao.BookingDAO#getAll()}.
	 */
	@Test
	void testGetAll() {
		Booking b = new Booking();
		b.setActive(true);
		b.setConfirmationCode("confirmCode725");
		b.setId(725);
		try {
			assertEquals(0, bdao.getAll().size());
			bdao.add(b);
			assertEquals(1, bdao.getAll().size());
			bdao.delete(b);
			assertEquals(0, bdao.getAll().size());
		} catch (ClassNotFoundException | SQLException e) {
			fail();
			e.printStackTrace();
		}
	}

}
