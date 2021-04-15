/**
 * 
 */
package dayFive.lambdasAndFunctionalInterfaces.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dayFive.lambdasAndFunctionalInterfaces.lambdaSort.StringSorter;

/**
 * @author Parker W.
 *
 */
class StringSorterTest {

	/**
	 * Test method for {@link dayFive.lambdasAndFunctionalInterfaces.lambdaSort.StringSorter#compStrings(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCompStrings() {
		String s1 = "test";
		String s2 = "e-test";
		String s3 = "e test word";
		String s4 = "non e test word";
		assertEquals(1, StringSorter.compStrings(s1, s2));
		assertEquals(0, StringSorter.compStrings(s2, s3));
		assertEquals(-1, StringSorter.compStrings(s3, s4));
		assertEquals(0, StringSorter.compStrings(s1, s4));
	}

}
