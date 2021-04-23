/**
 * 
 */
package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.de.Flight;

/**
 * @author Parker W.
 *
 */
public class ReadSeatsMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		GetFlightMenu menu = new GetFlightMenu();
		Scanner input = new Scanner(System.in);
		String option = "y";
		do {
			Flight flight = menu.getItem(conn);
			if (flight != null) {
				System.out.println("Selected flight " + flight);
				System.out.println("Available seats for flight: "
						+ (flight.getPlane().getType().getCapacity() - flight.getReservedSeats()));
				System.out.println("Reserved seats for flight: " + flight.getReservedSeats());

				System.out.println("Lookup more seats? (y/n)");
				option = input.nextLine();

				if (option.equals("")) {
					return;
				}
			} else {
				return;
			}

		} while (option.toLowerCase().charAt(0) == 'y');

	}

}
