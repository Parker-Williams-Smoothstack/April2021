/**
 * 
 */
package producerConsumer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import producerConsumer.PCDExample.Buffer;

/**
 * @author Parker W.
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ PCDExample.Buffer.class, PCDExample.class })
class PCDExampleTestSuite {

	/**
	 * Test method for {@link producerConsumer.PCDExample#main(java.lang.String[])}.
	 */
	@Test
	void testMain() {
		PCDExample.main(null);
	}

	/**
	 * Test method for {@link producerConsumer.PCDExample.Buffer#enqueue(int)}.
	 */
	@Test
	void testEnqueue() {
		Buffer buffer = new PCDExample.Buffer();
		buffer.clear();
		for (int i = 0; i < 7; i++) {
			buffer.enqueue(i);
		}
		try {
			buffer.enqueue(7);
			fail("Should have thrown an out of bounds exception");
		} catch (ArrayIndexOutOfBoundsException e) {
			// pass
			assertTrue(true); // passed the test to add one too many items
		}
	}

	/**
	 * Test method for {@link producerConsumer.PCDExample.Buffer#dequeue()}.
	 */
	@Test
	void testDequeue() {
		Buffer buffer = new PCDExample.Buffer();
		buffer.clear();
		for (int i = 0; i < 7; i++) {
			buffer.enqueue(i);
		}
		for (int i = 0; i < 7; i++) {
			buffer.dequeue();
		}
		try {
			buffer.dequeue();
			fail("Should have thrown an out of bounds exception");
		} catch (ArrayIndexOutOfBoundsException e) {
			assertTrue(true); // passed the test to remove one too many items
		}
	}

	/**
	 * Test method for {@link producerConsumer.PCDExample.Buffer#clear()}.
	 */
	@Test
	void testClear() {
		Buffer buffer = new PCDExample.Buffer();
		try {
			for (int i = 0; i < 7; i++) {
				buffer.enqueue(i);
			}
			buffer.clear();
			for (int i = 0; i < 7; i++) {
				buffer.enqueue(i);
			}
			assertTrue(true); //
		} catch (ArrayIndexOutOfBoundsException e) {
			fail("Clearing the buffer should have emptied it and allowed more data in");
		}
	}
}
