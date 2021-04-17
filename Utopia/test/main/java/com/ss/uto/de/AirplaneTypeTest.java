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
class AirplaneTypeTest {

	/**
	 * Test method for {@link com.ss.uto.de.AirplaneType#hashCode()}.
	 */
	@Test
	void testHashCode() {
		AirplaneType type1 = new AirplaneType();
		AirplaneType type2 = new AirplaneType();
		assertEquals(type1.hashCode(), type2.hashCode());
		type1.setCapacity(10);
		assertNotEquals(type1.hashCode(), type2.hashCode());
	}

	/**
	 * Test method for {@link com.ss.uto.de.AirplaneType#getType()}.
	 */
	@Test
	void testGetType() {
		AirplaneType type1 = new AirplaneType();
		assertNull(type1.getType());
		type1.setType(5);
		assertEquals(5, type1.getType());
	}

	/**
	 * Test method for {@link com.ss.uto.de.AirplaneType#setType(java.lang.Integer)}.
	 */
	@Test
	void testSetType() {
		AirplaneType type1 = new AirplaneType();
		assertNull(type1.getType());
		type1.setType(5);
		assertEquals(5, type1.getType());
	}

	/**
	 * Test method for {@link com.ss.uto.de.AirplaneType#getCapacity()}.
	 */
	@Test
	void testGetCapacity() {
		AirplaneType type1 = new AirplaneType();
		assertNull(type1.getCapacity());
		type1.setCapacity(5);
		assertEquals(5, type1.getCapacity());
	}

	/**
	 * Test method for {@link com.ss.uto.de.AirplaneType#setCapacity(java.lang.Integer)}.
	 */
	@Test
	void testSetCapacity() {
		AirplaneType type1 = new AirplaneType();
		assertNull(type1.getCapacity());
		type1.setCapacity(5);
		assertEquals(5, type1.getCapacity());
		type1.setCapacity(10);
		assertEquals(10, type1.getCapacity());
	}

	/**
	 * Test method for {@link com.ss.uto.de.AirplaneType#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		AirplaneType type1 = new AirplaneType();
		AirplaneType type2 = new AirplaneType();
		assertEquals(type1, type2);
		type1.setCapacity(10);
		assertNotEquals(type1, type2);
		type2.setCapacity(10);
		assertEquals(type1, type2);
	}

}
