/**
 * 
 */
package lambdas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lambdas.Lambda;

/**
 * @author Parker W.
 *
 */
class LambdaTest {

	/**
	 * Test method for {@link lambdas.Lambda#runOperation(int, int)}.
	 */
	@Test
	void testRunOperation() {
		Lambda l = new Lambda();

		assertTrue(l.runOperation(1, 7));
		assertFalse(l.runOperation(1, 88));

		assertTrue(l.runOperation(2, 1));
		assertTrue(l.runOperation(2, 2));
		assertTrue(l.runOperation(2, 3));
		assertFalse(l.runOperation(2, 4));
		assertTrue(l.runOperation(2, 5));
		assertFalse(l.runOperation(2, 9));

		assertTrue(l.runOperation(3, 7));
		assertTrue(l.runOperation(3, 77));
		assertTrue(l.runOperation(3, 787));
		assertFalse(l.runOperation(3, 778));

		assertThrows(IllegalArgumentException.class, () -> l.runOperation(5, 10));
	}

}
