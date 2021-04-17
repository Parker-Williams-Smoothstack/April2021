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
import com.ss.uto.de.BookingAgent;
import com.ss.uto.utils.ConnectionUtility;

/**
 * @author Parker W.
 *
 */
class BookingAgentDAOTest {
	ConnectionUtility conUtil = new ConnectionUtility();
	Connection conn;
	BookingAgentDAO bdao;
	BookingDAO bookDAO;
	Booking booking = new Booking();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		conn = conUtil.getConnection();
		bdao = new BookingAgentDAO(conn);
		bookDAO = new BookingDAO(conn);
		booking.setActive(true);
		booking.setConfirmationCode("confirm code 1");
		booking.setId(1);
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
	 * {@link com.ss.uto.dao.BookingAgentDAO#add(com.ss.uto.de.BookingAgent)}.
	 */
	@Test
	void testAddBookingAgent() {
		BookingAgent ba = new BookingAgent();
		ba.setBooking(booking);
		ba.setId(1);
		try {
			bookDAO.add(booking);

			assertEquals(0, bdao.getAll().size());
			bdao.add(ba);
			assertEquals(1, bdao.getAll().size());

			bdao.delete(ba);
			//bookDAO.delete(booking);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test method for
	 * {@link com.ss.uto.dao.BookingAgentDAO#update(com.ss.uto.de.BookingAgent)}.
	 */
//	@Test
//	void testUpdateBookingAgent() {
//		BookingAgent ba = new BookingAgent();
//		ba.setBooking(booking);
//		ba.setId(1);
//		try {
//			bookDAO.add(booking);
//			booking.setId(2);
//			bookDAO.add(booking);
//
//			bdao.add(ba);
//			assertEquals(1, bdao.getAll().get(0).getBooking().getId());
//			ba.setBooking(booking);
//			bdao.update(ba);
//			assertEquals(2, bdao.getAll().get(0).getBooking().getId());
//
//			bdao.delete(ba);
//			bookDAO.delete(booking);
//			booking.setId(1);
//			bookDAO.delete(booking);
//		} catch (ClassNotFoundException | SQLException e) {
//			fail();
//			e.printStackTrace();
//		}
//	}

	/**
	 * Test method for
	 * {@link com.ss.uto.dao.BookingAgentDAO#delete(com.ss.uto.de.BookingAgent)}.
	 */
//	@Test
//	void testDeleteBookingAgent() {
//		BookingAgent ba = new BookingAgent();
//		ba.setBooking(booking);
//		ba.setId(1);
//		try {
//			bookDAO.add(booking);
//
//			assertEquals(0, bdao.getAll().size());
//			bdao.add(ba);
//			assertEquals(1, bdao.getAll().size());
//
//			bdao.delete(ba);
//			bookDAO.delete(booking);
//			assertEquals(0, bdao.getAll().size());
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//			fail();
//		}
//	}

	/**
	 * Test method for {@link com.ss.uto.dao.BookingAgentDAO#getAll()}.
	 */
//	@Test
//	void testGetAll() {
//		BookingAgent ba = new BookingAgent();
//		ba.setBooking(booking);
//		ba.setId(1);
//		try {
//			bookDAO.add(booking);
//
//			assertEquals(0, bdao.getAll().size());
//			bdao.add(ba);
//			assertEquals(1, bdao.getAll().size());
//
//			bdao.delete(ba);
//			bookDAO.delete(booking);
//			assertEquals(0, bdao.getAll().size());
//		} catch (ClassNotFoundException | SQLException e) {
//			fail();
//			e.printStackTrace();
//		}
//	}

}
