/**
 * 
 */
package singleton.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import singleton.SampleSingleton;

/**
 * @author Parker W.
 *
 */
class SampleSingletonTest {

	/**
	 * Test method for {@link singleton.SampleSingleton#getInstance()}.
	 */
	@Test
	void testGetInstance() {
		SampleSingleton ss = null;
		assertNull(ss);
		ss = SampleSingleton.getInstance();
		assertNotNull(ss);
	}

}
