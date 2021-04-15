package dayFour.deadlock;

/**
 * 
 * @author Parker W.
 *
 */
public class DeadlockExample {

	/**
	 * Should cause a deadlock as t1 will lock lock1 and ask for lock2 while t2 locks lock2 and asks for lock1
	 * @param args
	 */
	public static void main(String[] args) {
		//generic lock objects
		Object lock1 = new Object();
		Object lock2 = new Object();

		//Thread that hold lock1 then asks for lock2
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					synchronized (lock1) {
						Thread.sleep(100);
						synchronized (lock2) {
							System.out.println("Thread One completed.");
						}
					}

				} catch (Exception e) {

				}
			}

		});

		//Thread that holds lock2 then asks for lock1
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					synchronized (lock2) {
						Thread.sleep(100);
						synchronized (lock1) {
							System.out.println("Thread Two completed.");
						}
					}

				} catch (Exception e) {

				}
			}

		});

		System.out.println("Starting threads");
		t1.start();
		t2.start();
		System.out.println("Threads started");

	}

}
