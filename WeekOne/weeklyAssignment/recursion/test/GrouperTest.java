/**
 * 
 */
package recursion.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import recursion.Grouper;

/**
 * @author Parker W.
 *
 */
class GrouperTest {

	/**
	 * Test method for {@link recursion.Grouper#groupSumClump(int, int[], int)}.
	 */
	@Test
	void testGroupSumClump() {
		Grouper g = new Grouper();
		int[] set1 = {2,4,8};
		int[] set2 = {1,2,4,8,1};
		int[] set3 = {2,4,4,8};
		int[] set4 = {2,2,2,5};
		
		assertTrue(g.groupSumClump(0, set4, 6));	//single group equals target
		assertFalse(g.groupSumClump(0, set4, 12));	//sum of group can't reach target
		assertFalse(g.groupSumClump(0, set4, 1));	//smallest int larger than target
		assertTrue(g.groupSumClump(0, set4, 11));	//total of set equals target
		
		assertTrue(g.groupSumClump(0, set1, 6));	//test first check in recursive call
		
		
		assertTrue(g.groupSumClump(0, set1 ,10));
		assertTrue(g.groupSumClump(0, set2, 14));
		assertFalse(g.groupSumClump(0, set3, 14));
		
		
	}

}
