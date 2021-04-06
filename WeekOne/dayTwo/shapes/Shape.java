/**
 * 
 */
package shapes;

/**
 * Interface to define what a shape must be capable of doing.
 * @author Parker W.
 *
 */
public interface Shape {
	/**
	 * Calculates the area of a shape
	 * @return the area
	 */
	Double calculateArea();
	
	/**
	 * Prints out the area of the shape along with any other information
	 */
	void display();

}
