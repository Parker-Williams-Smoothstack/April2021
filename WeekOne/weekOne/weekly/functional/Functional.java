package weekly.functional;

/**
 * 
 * @author Parker W.
 *
 */
public interface Functional<T> {
	
	/**
	 * Takes an input array of objects and returns a copy of the array after some operation has been performed
	 * @param inputs the initial array of objects
	 * @return the updated array of objects as a new array
	 */
	public T[] function(T[] inputs);
	
	
}
