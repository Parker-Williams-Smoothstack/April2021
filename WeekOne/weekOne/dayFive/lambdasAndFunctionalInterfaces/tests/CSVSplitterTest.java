/**
 * 
 */
package dayFive.lambdasAndFunctionalInterfaces.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import dayFive.lambdasAndFunctionalInterfaces.java8Features.CSVSplitter;

/**
 * @author Parker W.
 *
 */
class CSVSplitterTest {

	/**
	 * Test method for {@link dayFive.lambdasAndFunctionalInterfaces.java8Features.CSVSplitter#main(java.lang.String[])}.
	 */
	@Test
	void testMain() {
		String[] arg1 = {"1","2","3","4","5","6","7","8","9"};
		String[] arg2 = {"1","2","3","four","5","6","7","8","9"};
		CSVSplitter.main(arg1);
		assertThrows(NumberFormatException.class, () -> CSVSplitter.main(arg2));
		
	}

	/**
	 * Test method for {@link dayFive.lambdasAndFunctionalInterfaces.java8Features.CSVSplitter#intsToString(int[])}.
	 */
	@Test
	void testIntsToString() {
		int[] arg1 = {1,2,3,4};
		assertEquals("o1,e2,o3,e4", CSVSplitter.intsToString(arg1));
		
	}

	/**
	 * Test method for {@link dayFive.lambdasAndFunctionalInterfaces.java8Features.CSVSplitter#getAddendedString(int)}.
	 */
	@Test
	void testGetAddendedString() {
		int arg1 = 1;
		int arg2 = 80;
		//Comma is expected, trimming occurs in the testIntsToString method
		assertEquals("o1,", CSVSplitter.getAddendedString(arg1));
		assertEquals("e80,", CSVSplitter.getAddendedString(arg2));
	}

}
