/**
 * 
 */
package dayTwo.shapes;

/**
 * @author Parker W.
 *
 */
public class Triangle implements Shape {
	
	Double base;
	Double height;
	
	/**
	 * Constructs a triangle of the given dimensions
	 * @param base the base length
	 * @param height the height
	 */
	public Triangle(Double base, Double height) {
		this.base = base;
		this.height = height;
	}

	@Override
	public Double calculateArea() {
		return 0.5 * base * height;
	}

	@Override
	public void display() {
		System.out.println("The area of the triangle is: " + calculateArea());

	}

}
