/**
 * 
 */
package dateTime.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dateTime.examples.TimeExamples;

/**
 * @author Parker W.
 *
 */
class TimeExamplesTest {

	/**
	 * Test method for {@link dateTime.examples.TimeExamples#monthLength(int, int)}.
	 */
	@Test
	void testMonthLength() {
		TimeExamples mlfy = new TimeExamples();
		assertEquals(31, mlfy.monthLength(1970, 1));
		assertEquals(30, mlfy.monthLength(2021, 4));
		assertEquals(29, mlfy.monthLength(1996, 2));
		assertEquals(28, mlfy.monthLength(1997, 2));
	}
	
	
	/**
	 * Test method for {@link dateTime.examples.TimeExamples#getMondays(int)}.
	 */
	@Test
	void testGetMondays() {
		TimeExamples mlfy = new TimeExamples();
		int[] mons1 = {5,12,19,26};
		int[] result1 = mlfy.getMondays(4);
		for(int i = 0; i < mons1.length; i++)
			assertEquals(mons1[i], result1[i]);
		
		int[] mons2 = {3,10,17,24,31};
		int[] result2 = mlfy.getMondays(5);
		for(int i = 0; i < mons2.length; i++)
			assertEquals(mons2[i], result2[i]);
	}
	
	/**
	 * Test method for {@link dateTime.examples.TimeExamples#isFridayTheThirteenth(int, int, int)}.
	 */
	@Test
	void testIsFridayTheThirteenth() {
		TimeExamples mlfy = new TimeExamples();
		assertTrue(mlfy.isFridayTheThirteenth(8,13,2021));
		assertFalse(mlfy.isFridayTheThirteenth(7,13,2021));
	}
	
}
