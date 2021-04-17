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
class BookingTest {

	/**
	 * Test method for {@link com.ss.uto.de.Booking#hashCode()}.
	 */
	@Test
	void testHashCode() {
		Booking b1 = new Booking();
		Booking b2 = new Booking();
		assertEquals(b1.hashCode(), b2.hashCode());
		b1.setActive(true);
		b2.setActive(false);
		assertNotEquals(b1.hashCode() , b2.hashCode());
		b2.setActive(true);
		assertEquals(b1.hashCode(), b2.hashCode());
	}

	/**
	 * Test method for {@link com.ss.uto.de.Booking#getId()}.
	 */
	@Test
	void testGetId() {
		Booking b = new Booking();
		assertNull(b.getId());
		b.setId(5);
		assertEquals(5,  b.getId());
		b.setId(10);
		assertEquals(10,  b.getId());
	}

	/**
	 * Test method for {@link com.ss.uto.de.Booking#setId(java.lang.Integer)}.
	 */
	@Test
	void testSetId() {
		Booking b = new Booking();
		assertNull(b.getId());
		b.setId(5);
		assertEquals(5,  b.getId());
		b.setId(10);
		assertEquals(10,  b.getId());
	}

	/**
	 * Test method for {@link com.ss.uto.de.Booking#isActive()}.
	 */
	@Test
	void testIsActive() {
		Booking b = new Booking();
		assertFalse(b.isActive());
		b.setActive(true);
		assertTrue(b.isActive());
		b.setActive(false);
		assertFalse(b.isActive());
	}

	/**
	 * Test method for {@link com.ss.uto.de.Booking#setActive(boolean)}.
	 */
	@Test
	void testSetActive() {
		Booking b = new Booking();
		assertFalse(b.isActive());
		b.setActive(true);
		assertTrue(b.isActive());
		b.setActive(false);
		assertFalse(b.isActive());
	}

	/**
	 * Test method for {@link com.ss.uto.de.Booking#getConfirmationCode()}.
	 */
	@Test
	void testGetConfirmationCode() {
		Booking b = new Booking();
		assertNull(b.getConfirmationCode());
		b.setConfirmationCode("ABC123");
		assertEquals("ABC123",  b.getConfirmationCode());
		b.setConfirmationCode("DEF456");
		assertEquals("DEF456",  b.getConfirmationCode());
	}

	/**
	 * Test method for {@link com.ss.uto.de.Booking#setConfirmationCode(java.lang.String)}.
	 */
	@Test
	void testSetConfirmationCode() {
		Booking b = new Booking();
		assertNull(b.getConfirmationCode());
		b.setConfirmationCode("ABC123");
		assertEquals("ABC123",  b.getConfirmationCode());
		b.setConfirmationCode("DEF456");
		assertEquals("DEF456",  b.getConfirmationCode());
	}

	/**
	 * Test method for {@link com.ss.uto.de.Booking#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		Booking b1 = new Booking();
		Booking b2 = new Booking();
		assertEquals(b1, b2);
		b1.setActive(true);
		b2.setActive(false);
		assertNotEquals(b1,b2);
		b2.setActive(true);
		assertEquals(b1, b2);
	}

}
