package dayFive.lambdasAndFunctionalInterfaces.lambdaSort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringSorter {

	public static void main(String[] args) {
		String[] list = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December", "Everyone", "everyone" };

		for (String s : list)
			System.out.println(s);
		
		System.out.println("==========Sorted by shortest to longest===========");

		Arrays.stream(list).sorted((s1, s2) -> {
			return s1.length() - s2.length();
		}).collect(Collectors.toList()).forEach(s -> System.out.println(s));
		
		
		System.out.println("==========Sorted by longest to shortest===========");
		Arrays.stream(list).sorted((s1, s2) -> {
			return s2.length() - s1.length();
		}).collect(Collectors.toList()).forEach(s -> System.out.println(s));
		
		System.out.println("==========Sorted by first letter===========");
		Arrays.stream(list).sorted((s1, s2) -> {
			return s1.charAt(0) - s2.charAt(0);
		}).collect(Collectors.toList()).forEach(s -> System.out.println(s));
		
		System.out.println("==========Sorted by if it starts with \"e\"===========");
		Arrays.stream(list).sorted((s1, s2) -> compStrings(s1, s2)).collect(Collectors.toList()).forEach(s -> System.out.println(s));

	}
	
	/**
	 * Static helper method, sorts two string based on if they start with the letter lowercase e or not
	 * @param s1	string one
	 * @param s2	string two
	 * @return		0 if equal, positive 1 if string one goes first, negative one if string 2 goes first
	 */
	public static int compStrings(String s1, String s2) {
		if(s1.charAt(0) == 'e')
			return s2.charAt(0) == 'e' ? 0 : -1;
		return s2.charAt(0) == 'e' ? 1 : 0;
	}

}
