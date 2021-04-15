/**
 * 
 */
package weekly.lambdas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import weekly.lambdas.Lambda;
import weekly.lambdas.Lambda.Operations;

/**
 * @author Parker W.
 *
 */
class LambdaTest {

	/**
	 * Test method for {@link weekly.lambdas.Lambda#runOperation(int, int)}.
	 */
	@Test
	void testRunOperation() {
		Lambda l = new Lambda();
		
		

		assertTrue(l.runOperation(Operations.ISODD, 7));
		assertFalse(l.runOperation(Operations.ISODD, 88));

		assertTrue(l.runOperation(Operations.ISPRIME, 1));
		assertTrue(l.runOperation(Operations.ISPRIME, 2));
		assertTrue(l.runOperation(Operations.ISPRIME, 3));
		assertFalse(l.runOperation(Operations.ISPRIME, 4));
		assertTrue(l.runOperation(Operations.ISPRIME, 5));
		assertFalse(l.runOperation(Operations.ISPRIME, 9));

		assertTrue(l.runOperation(Operations.ISPALINDROME, 7));
		assertTrue(l.runOperation(Operations.ISPALINDROME, 77));
		assertTrue(l.runOperation(Operations.ISPALINDROME, 787));
		assertFalse(l.runOperation(Operations.ISPALINDROME, 778));
	}

}
