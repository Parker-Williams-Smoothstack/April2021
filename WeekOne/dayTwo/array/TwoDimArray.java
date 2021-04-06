package array;

import java.util.Random;

/**
 * Assignment: Construct a 2D array and find the max number and show its position in an array
 * @author Parker W.
 *
 */
public class TwoDimArray {

	/**
	 * Runner method
	 * @param args
	 */
	public static void main(String[] args) {
		
		//create randomly sized array and give it random data
		Random rand = new Random();
		Integer len = rand.nextInt(9) + 1;
		Integer wid = rand.nextInt(9) + 1;
		Integer[][] arr = new Integer[len][wid];
		
		for(int i = 0; i < len; i++)
			for(int j = 0; j < wid; j++)
				arr[i][j] = rand.nextInt();
		
		//debug: comment out lines 13-17 and uncomment 20 to ensure that the rows/cols aren't swapped
		//Integer[][] arr = {{0,1,2},{5,4,3},{5,5,5}};		
		
		//continue under assumption that the array was given to us and that the dimensions are not already known
		//store the dimensions to reduce calls to .length
		Integer length = arr.length;	
		Integer width = arr[0].length;
		Integer maxRow = 0;
		Integer maxCol = 0;
		Integer maxValue = arr[0][0];	//make sure the value is at least actually in the array
		for(int i = 0; i < length; i++)
			for(int j = 0; j < width; j++)
				if(maxValue < arr[i][j]) {
					maxValue = arr[i][j];
					maxRow = i;
					maxCol = j;
				}
				
		System.out.println("The maximum value is " + maxValue + " located at [" + maxRow + "][" + maxCol + "]");

	}

}
