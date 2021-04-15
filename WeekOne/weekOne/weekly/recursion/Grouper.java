/**
 * 
 */
package weekly.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Parker W.
 *
 */
public class Grouper {

	/**
	 * Determines if it is possible to reach the target value by summing a group of
	 * the numbers, but if there are multiple of the same number in a group
	 * (sequential to each other) then all of the numbers must be used.
	 * 
	 * For example {1,2,2,2,5,2} could use the lone 2 at index 5, no 2 at all, or
	 * all three 2's at indeces 1 to 3
	 * 
	 * @param x       number of groups to add together and test
	 * @param numbers the list of available numbers
	 * @param target  the target sum to reach
	 * @return if the target can be reached with the given numbers, groups of
	 *         numbers must be used together
	 */
	public boolean groupSumClump(int x, int[] numbers, int target) {
		Integer total = 0;
		int minimum = numbers[0];
		List<Integer> condensedGroup = new ArrayList<>();
		int groupTotal = 0;
		int group = numbers[0];
		for (int n : numbers) {
			total += n;
			minimum = minimum < n ? minimum : n;
			// go ahead and condense the groups will iterating, will reduce runtime cost
			if (n == group) {
				groupTotal += n; // if the new number is the same as the previous add it to the total
			} else { // finished the group, add the total to the condensed list and start the next
						// grouping
				if (groupTotal == target)
					return true;
				condensedGroup.add(groupTotal);
				group = n;
				groupTotal = n;
			}
		}

		if (total < target)
			return false;

		if (total == target)
			return true;
		
		if(minimum > target)
			return false;

		Integer[] condArray = condensedGroup.toArray(a -> {
			return new Integer[a];
		});

		return groupSumClumpRecursive(0, target, condArray);

	}

	/**
	 * checks to see if the target can be reached using groups of numbers in a recursive manner
	 * @param total	the current total of the search
	 * @param target the target sum
	 * @param numbers the list of all groups, with groupings of equal numbers already condensed
	 * @param usedNumbers list of all numbers currently in the total
	 * @return if the target can be reached
	 */
	private boolean groupSumClumpRecursive(int total, int target, Integer[] numbers, Integer... usedNumbers) {
		//operate like a breadth-first search with each of the available groups as a node
		List<Integer> options = new ArrayList<>();
		List<Integer> used = new ArrayList<>();
		for(Integer n : numbers) {
			//add all numbers to the list of options
			if(total + n == target)	//if it immediately hits the target return true
				return true;

			if(total + n < target)	//don't include values that overshoot the target
				options.add(n);
		}
			
		for(Integer un : usedNumbers) {
			used.add(un);
			if(options.contains(un)) {
				options.remove(un);	//remove any numbers already included in the total from the options
			}
		}
		
		for(Integer o : options) {
			used.add(o);	//add the next option to the used list
			if(groupSumClumpRecursive(total + o, target, numbers, used.toArray(a -> {return new Integer[a];})))
				return true;	//sub-call found a path, return true
		}		
		
		return false;	//if every possible branch from the current position failed to reach the target return false
		
	}

}
