package weekly.lambdas;

/**
 * Functional interface for running an operation
 * @author Parker W.
 *
 */
public interface PerformOperation {

	/**
	 * Functional method that returns a boolean value based on an input int
	 * @param input the number to perform the operation on
	 * @return the boolean result of the operation
	 */
	public boolean operation(int input);
	
}
