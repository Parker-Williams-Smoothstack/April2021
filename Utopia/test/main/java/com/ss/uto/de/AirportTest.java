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
class AirportTest {

	/**
	 * Test method for {@link com.ss.uto.de.Airport#hashCode()}.
	 */
	@Test
	void testHashCode() {
		Airport port1 = new Airport();
		Airport port2 = new Airport();
		assertEquals(port1.hashCode(), port2.hashCode());
		port1.setCode("ABC");
		assertNotEquals(port1.hashCode(), port2.hashCode());
		port2.setCode("ABC");
		assertEquals(port1.hashCode(), port2.hashCode());
	}

	/**
	 * Test method for {@link com.ss.uto.de.Airport#getCode()}.
	 */
	@Test
	void testGetCode() {
		Airport port = new Airport();
		assertNull(port.getCode());
		port.setCode("BCA");
		assertEquals("BCA", port.getCode());
		port.setCode("ABC");
		assertEquals("ABC", port.getCode());
	}

	/**
	 * Test method for {@link com.ss.uto.de.Airport#setCode(java.lang.String)}.
	 */
	@Test
	void testSetCode() {
		Airport port = new Airport();
		assertNull(port.getCode());
		port.setCode("BCA");
		assertEquals("BCA", port.getCode());
		port.setCode("ABC");
		assertEquals("ABC", port.getCode());
	}

	/**
	 * Test method for {@link com.ss.uto.de.Airport#getCityName()}.
	 */
	@Test
	void testGetCityName() {
		Airport port = new Airport();
		assertNull(port.getCode());
		port.setCityName("BCA");
		assertEquals("BCA", port.getCityName());
		port.setCityName("ABC");
		assertEquals("ABC", port.getCityName());
	}

	/**
	 * Test method for {@link com.ss.uto.de.Airport#setCityName(java.lang.String)}.
	 */
	@Test
	void testSetCityName() {
		Airport port = new Airport();
		assertNull(port.getCode());
		port.setCityName("BCA");
		assertEquals("BCA", port.getCityName());
		port.setCityName("ABC");
		assertEquals("ABC", port.getCityName());
	}

	/**
	 * Test method for {@link com.ss.uto.de.Airport#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		Airport port1 = new Airport();
		Airport port2 = new Airport();
		assertEquals(port1, port2);
		port1.setCode("ABC");
		assertNotEquals(port1, port2);
		port2.setCode("ABC");
		assertEquals(port1, port2);
	}

}
