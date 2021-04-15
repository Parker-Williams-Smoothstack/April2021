/**
 * 
 */
package dayFour.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Parker W.
 *
 */
class LineTest {

	/**
	 * Test method for {@link dayFour.test.Line#Line(double, double, double, double)}.
	 */
	@Test
	void testLine() {
		Line ex = null;
		assertNull(ex);
		ex = new Line(0,0,5,5);
		assertNotNull(ex);
	}

	/**
	 * Test method for {@link dayFour.test.Line#getSlope()}.
	 */
	@Test
	void testGetSlope() {
		Line ex = new Line(0,0,5,5);
		assertEquals(1, ex.getSlope());
		ex = new Line(0,0,0,5);
		double slope = 0;
		try {
			slope = ex.getSlope();
			fail("Can't get slope of vertical line");
		} catch(ArithmeticException e) {
			assertEquals(0, slope);
		}
	}

	/**
	 * Test method for {@link dayFour.test.Line#getDistance()}.
	 */
	@Test
	void testGetDistance() {
		Line ex = new Line(0,0,1,0);
		assertEquals(1, ex.getDistance());
		ex = new Line(0,0,3,4);
		assertEquals(5, ex.getDistance());
	}

	/**
	 * Test method for {@link dayFour.test.Line#parallelTo(dayFour.test.Line)}.
	 */
	@Test
	void testParallelTo() {
		Line ex1 = new Line(0,0,1,0);
		Line ex2 = new Line(1,1,2,1);
		Line ex3 = new Line(0,0,1,1);
		assertTrue(ex1.parallelTo(ex2));
		assertFalse(ex1.parallelTo(ex3));
	}

}
