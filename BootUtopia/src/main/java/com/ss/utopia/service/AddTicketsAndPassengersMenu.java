/**
 * 
 */
package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.dao.BookingDAO;
import com.ss.uto.de.Booking;

/**
 * @author Parker W.
 *
 */
public class AddTicketsAndPassengersMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		// Tickets are presumed to be bookings, and passengers presumed handled by the
		// Traveler menus
		BookingDAO bdao = new BookingDAO(conn);
		Booking booking = new Booking();
		Scanner input = new Scanner(System.in);

		System.out.print("Please enter your confirmation code: ");
		booking.setConfirmationCode(input.nextLine());
		System.out.print("\nPlease enter y/n for if your booking is active: ");
		String active = input.nextLine();
		if (active.toLowerCase().charAt(0) == 'y') {
			booking.setActive(true);
		} else {
			booking.setActive(false);
		}
		//clear the input for the any other menues that might become confused
		input.nextLine();
		try {
			bdao.add(booking);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
