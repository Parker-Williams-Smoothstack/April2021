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
class AirplaneTest {

	/**
	 * Test method for {@link com.ss.uto.de.Airplane#hashCode()}.
	 */
	@Test
	void testHashCode() {
		Airplane plane1 = new Airplane();
		Airplane plane2 = new Airplane();
		assertEquals(plane1.hashCode(), plane2.hashCode());
		plane1.setId(5);
		assertNotEquals(plane1.hashCode(), plane2.hashCode());
	}

	/**
	 * Test method for {@link com.ss.uto.de.Airplane#getId()}.
	 */
	@Test
	void testGetId() {
		Airplane plane1 = new Airplane();
		assertNull(plane1.getId());
		plane1.setId(5);
		assertEquals(5, plane1.getId());
	}

	/**
	 * Test method for {@link com.ss.uto.de.Airplane#setId(java.lang.Integer)}.
	 */
	@Test
	void testSetId() {
		Airplane plane1 = new Airplane();
		assertNull(plane1.getId());
		plane1.setId(5);
		assertEquals(5, plane1.getId());
	}

	/**
	 * Test method for {@link com.ss.uto.de.Airplane#getType()}.
	 */
	@Test
	void testGetType() {
		Airplane plane1 = new Airplane();
		assertNotNull(plane1.getType());
		assertNull(plane1.getType().getType());
	}

	/**
	 * Test method for {@link com.ss.uto.de.Airplane#setType(com.ss.uto.de.AirplaneType)}.
	 */
	@Test
	void testSetType() {
		Airplane plane1 = new Airplane();
		AirplaneType type = new AirplaneType();
		type.setCapacity(10);
		assertNotEquals(plane1.getType(), type);
		plane1.setType(type);
		assertEquals(plane1.getType(), type);
	}

	/**
	 * Test method for {@link com.ss.uto.de.Airplane#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		Airplane plane1 = new Airplane();
		Airplane plane2 = new Airplane();
		assertEquals(plane1, plane2);
		plane1.setId(5);
		assertNotEquals(plane1, plane2);
	}

}
