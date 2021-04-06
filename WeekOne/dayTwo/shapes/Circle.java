/**
 * 
 */
package shapes;

/**
 * @author Parker W.
 *
 */
public class Circle implements Shape {
	
	//radius of the circle
	Double radius;
	
	/**
	 * Constructs a circle of the given radius
	 * @param radius the radius
	 */
	public Circle(Double radius) {
		this.radius = radius;
	}

	@Override
	public Double calculateArea() {
		return radius * radius * Math.PI;
	}

	@Override
	public void display() {
		System.out.println("The area of the circle is: " + calculateArea());
	}

}
