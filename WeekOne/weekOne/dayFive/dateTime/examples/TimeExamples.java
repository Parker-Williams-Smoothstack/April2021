/**
 * 
 */
package dayFive.dateTime.examples;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Parker W.
 *
 */
public class TimeExamples {

	/**
	 * Returns the length of a given month inside a given year
	 * 
	 * @param year  the year to look at
	 * @param month the month to get the length of
	 * @return the number of days in the given month that year
	 */
	public int monthLength(int year, int month) {
		if (month > 12 || month < 1 || year < 0) {
			throw new IllegalArgumentException();
		} else {
			return Month.values()[month - 1].length(Year.isLeap(year));
		}

	}

	/**
	 * Gets all the Mondays for the given month of the current year
	 * 
	 * @param month the desired month
	 * @return an array of all the Mondays
	 */
	public int[] getMondays(int month) {
		if (month > 12 || month < 1) {
			throw new IllegalArgumentException();
		} else {

			List<Integer> mondays = new ArrayList<>();

			Calendar cal = Calendar.getInstance();
			cal.set(LocalDate.now().getYear(), month - 1, 0);
			Month m = Month.values()[month - 1];
			int days = m.length(Year.isLeap(LocalDate.now().getYear()));

			for (int i = 0; i <= days; i++) {
				//System.out.println(cal.get(Calendar.DAY_OF_WEEK));
				if (cal.get(Calendar.DAY_OF_WEEK) == 2) {
					System.out.println(m.name() + " " + i + " is a Monday");
					mondays.add(i);
				}
				cal.add(Calendar.DATE, 1);
			}

			int[] monsAsArray = new int[mondays.size()];
			int total = 0;
			for (Integer i : mondays) {
				monsAsArray[total++] = i;
			}
			return monsAsArray;
		}
	}

	public boolean isFridayTheThirteenth(int month, int day, int year) {

		if (month > 12 || month < 1 || year < 0 || day > 31 || day < 1) {
			throw new IllegalArgumentException();
		} else {
			if (day != 13)
				return false;
			
			Calendar cal = Calendar.getInstance();
			cal.set(year, month - 1, day - 1);
			return cal.get(Calendar.DAY_OF_WEEK) == 5;
		}

	}

}
