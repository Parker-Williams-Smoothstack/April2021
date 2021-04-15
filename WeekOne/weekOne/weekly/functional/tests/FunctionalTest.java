/**
 * 
 */
package weekly.functional.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import weekly.functional.FunctionalExample;

/**
 * @author Parker W.
 *
 */
class FunctionalTest {
	FunctionalExample fe = new FunctionalExample();

	@Test
	void testRightDigit() {
		
		
		Integer[] numbers = {10,11,12,72,1005,892};
		Integer[] digits = {0,1,2,2,5,2};
		Integer[] result = fe.rightDigits.function(numbers);
		for(int i = 0; i < digits.length; i++)
			assertEquals(digits[i], result[i]);
	}

	@Test
	void testMultiplyByTwo() {
		
		
		Integer[] numbers = {10,11,12,72,1005,47};
		Integer[] digits = {20,22,24,144,2010,94};
		Integer[] result = fe.multiplyByTwo.function(numbers);
		for(int i = 0; i < digits.length; i++)
			assertEquals(digits[i], result[i]);
	}
	
	@Test
	void testRemoveX() {
		
		
		String[] input = {"x", "marks", "spot","maximum","minimumx"};
		String[] expected = {"","marks","spot","maimum","minimum"};
		String[] result = fe.removeX.function(input);
		for(int i = 0; i < result.length; i++)
			assertEquals(expected[i], result[i]);
	}

}
