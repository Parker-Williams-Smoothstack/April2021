/**
 * 
 */
package lambdasAndFunctionalInterfaces.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lambdasAndFunctionalInterfaces.stringFilter.FilterByKey;

/**
 * @author Parker W.
 *
 */
class FilterByKeyTest {

	/**
	 * Test method for {@link lambdasAndFunctionalInterfaces.stringFilter.FilterByKey#filterList(java.lang.String[])}.
	 */
	@Test
	void testFilterList() {
		String[] list = FilterByKey.filterList("and","this","is","an","example","any","person","can","use","are");
		assertEquals(3, list.length);
		assertEquals("and", list[0]);
		assertEquals("any", list[1]);
		assertEquals("are", list[2]);
	}

}
