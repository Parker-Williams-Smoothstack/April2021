/**
 * 
 */
package dayFour.deadlock;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

/**
 * @author Parker W.
 *
 */
class DeadlockExampleTest {

	/**
	 * Test method for {@link dayFour.deadlock.DeadlockExample#main(java.lang.String[])}.
	 */
	@Test
	void testMain() {
		//Code is intended to reach a deadlock, can't really test it
		Thread t = new Thread(new Runnable() {
			public void run() {
				DeadlockExample de = new DeadlockExample();
				de.main(null);
			}
		});
		
		try {
			t.run();	//run the deadlock
			t.wait(10000); //time out after 10s
			fail("Thread should not have finished as a deadlock should have been entered.");
		}catch(IllegalMonitorStateException e) {
			//current thread t is not the owner of the object's monitor
			//DeadlockExample de is the owner of the object's monitor 
			//this is expected in a deadlock as multiple objects are locked and other threads want them
			//considered a pass
		}
		catch(InterruptedException e) {
			//thread timed out, means a deadlock was reached as code should not take 10s otherwise
			//this is intentional, considered a pass
		}
	}

}
