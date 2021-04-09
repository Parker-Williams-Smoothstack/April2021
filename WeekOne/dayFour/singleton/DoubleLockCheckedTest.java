/**
 * 
 */
package singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Parker W.
 *
 */
class DoubleLockCheckedTest {

	/**
	 * Test method for {@link singleton.DoubleLockChecked#getInstance()}.
	 */
	@Test
	void testGetInstance() {
		DoubleLockChecked dlc = null;
		assertNull(dlc);
		dlc = DoubleLockChecked.getInstance();
		assertNotNull(dlc);
		DoubleLockChecked dlc2 = DoubleLockChecked.getInstance();
		assertEquals(dlc, dlc2);
	}

}
