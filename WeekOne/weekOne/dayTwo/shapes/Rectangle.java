/**
 * 
 */
package dayTwo.shapes;

/**
 * @author Parker W.
 *
 */
public class Rectangle implements Shape {

	// A rectangle has a length and width, needed for things such as area
	Double length;
	Double width;

	/**
	 * Constructs a rectangle of the given dimensions
	 * @param length the length
	 * @param width the width
	 */
	public Rectangle(Double length, Double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	public Double calculateArea() {
		return length * width;
	}

	@Override
	public void display() {
		System.out.println("The area of the rectangle is: " + calculateArea());

	}

}
