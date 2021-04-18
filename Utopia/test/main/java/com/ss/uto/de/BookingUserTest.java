/**
 * 
 */
package com.ss.uto.de;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Parker W.
 *
 */
class BookingUserTest {

	/**
	 * Test method for {@link com.ss.uto.de.BookingUser#hashCode()}.
	 */
	@Test
	void testHashCode() {
		BookingUser u1 = new BookingUser();
		BookingUser u2 = new BookingUser();
	}

	/**
	 * Test method for {@link com.ss.uto.de.BookingUser#getBooking()}.
	 */
	@Test
	void testGetBooking() {
		BookingUser u = new BookingUser();
		Booking b = new Booking();
		assertEquals(b, u.getBooking());
		b.setId(5);
		u.getBooking().setId(10);
		assertNotEquals(b, u.getBooking());
		b.setId(10);
		assertEquals(b, u.getBooking());
	}

	/**
	 * Test method for {@link com.ss.uto.de.BookingUser#setBooking(com.ss.uto.de.Booking)}.
	 */
	@Test
	void testSetBooking() {
		BookingUser u = new BookingUser();
		Booking b = new Booking();
		assertEquals(b, u.getBooking());
		b.setId(5);
		u.getBooking().setId(10);
		assertNotEquals(b, u.getBooking());
		b.setId(10);
		assertEquals(b, u.getBooking());
	}

	/**
	 * Test method for {@link com.ss.uto.de.BookingUser#getId()}.
	 */
	@Test
	void testGetId() {
		BookingUser u = new BookingUser();
	}

	/**
	 * Test method for {@link com.ss.uto.de.BookingUser#setId(java.lang.Integer)}.
	 */
	@Test
	void testSetId() {
		BookingUser u = new BookingUser();
	}

	/**
	 * Test method for {@link com.ss.uto.de.BookingUser#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		BookingUser u1 = new BookingUser();
		BookingUser u2 = new BookingUser();
	}

}
