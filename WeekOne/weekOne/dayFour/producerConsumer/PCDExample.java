/**
 * 
 */
package dayFour.producerConsumer;

import java.util.Random;

/**
 * @author Parker W.
 *
 */
public class PCDExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
		Buffer sharedBuffer = new Buffer();
		Random rand = new Random();
		final int ITERATIONS = 25;	//determine the number of times run the threads
		
		Thread producer = new Thread(new Runnable() {
			@Override
			public void run() {
				//should add a random number to the buffer, announce it, then wait a random amount of time
				for(int i = 0; i < ITERATIONS; i++) {
					Integer input = rand.nextInt();
					synchronized(sharedBuffer) {
						sharedBuffer.enqueue(input);
						System.out.println("Added " + input + " to the buffer");	//Not sure println is thread safe but the sync should help
					}
				}
				
				
			}
		});
		
		Thread consumer = new Thread(new Runnable() {
			@Override
			public void run() {
				//remove from the buffer, display it, wait random amount of time
				for(int i = 0; i < ITERATIONS; i++) {
					synchronized (sharedBuffer) {
						Integer output = sharedBuffer.dequeue();
						System.out.println("Removed " + output + " from the buffer");
					}
				}
				
			}
		});
		
		System.out.println("Starting threads: Producer then consumer.");
		producer.start();
		//System.out.println("Producer started");	//uncommenting this will almost always cause the buffer to overflow
		consumer.start();
		System.out.println("Consumer started");
		System.out.println("Threads started");

	}

	/**
	 * A shared buffer that both the Producer and Consumer should work with.
	 * Slight naming error, method names imply queue but is really a stack
	 * 
	 * @author Parker W.
	 *
	 */
	public static class Buffer {
		int[] bufferData = new int[7];
		int size = 0;

		/**
		 * Adds given integer to the buffer
		 * @param input integer to enqueue
		 */
		public void enqueue(int input) {
			if (size == bufferData.length) {
				// at capacity
				System.err.println("Error: Attempted to add to a full buffer!");
				throw new ArrayIndexOutOfBoundsException();
			}
			bufferData[size++] = input;

		}

		/**
		 * Removes next element from the buffer
		 * @return top of the stack
		 */
		public int dequeue() {
			if (size == 0) {
				// empty
				System.err.println("Error: Attempted to remove from an empty buffer!");
				throw new ArrayIndexOutOfBoundsException();
			}
			return bufferData[--size];
		}
		
		/**
		 * Clears all the data because static contexts can interferre with tests
		 */
		public void clear() {
			bufferData = new int[7];
			size = 0;
		}
	}

}
