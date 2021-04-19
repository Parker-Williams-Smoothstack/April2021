/**
 * 
 */
package com.ss.uto.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.dao.FlightDAO;
import com.ss.uto.de.Flight;

/**
 * @author Parker W.
 *
 */
public class UpdateSeatsMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {

		// Seats are (believed to be) the difference between the max_capacity of an
		// airplane_type and reserved_seats of a flight
		// get the flight and its reserved seats, backtrack up and get the associated
		// airplane_type
		// show the menu and let the user enter the new number of available seats.
		// change reserved_seats to max_capacity
		// a1 = m - r1 ; r2 = m - a2

		GetFlightMenu menu = new GetFlightMenu();
		Scanner input = new Scanner(System.in);
		Flight workingFlight = menu.getItem(conn);
		Integer max = workingFlight.getPlane().getType().getCapacity();
		Integer updatedReserved = 0;
		System.out.println("Current number of available seats: " + workingFlight.getReservedSeats());
		System.out.println("Max capacity of the plane is: " + max);
		System.out.println("Please enter the new number of available seats: ");
		updatedReserved = max - input.nextInt();
		workingFlight.setReservedSeats(updatedReserved);
		FlightDAO fdao = new FlightDAO(conn);
		try {
			fdao.update(workingFlight);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		input.nextLine();
		input.close();

	}

}
