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
public class OverrideCancellationMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		// Should let the user get a cancelled trip and undo that cancellation
		// in other words, display all inactive trips, select one, set to active
		GetCancelledTripsMenu menu = new GetCancelledTripsMenu();
		Booking booking = menu.getItem(conn);
		Scanner input = new Scanner(System.in);
		BookingDAO bdao = new BookingDAO(conn);

		// confirm delete
		System.out.println("Are you sure you wish to override the following cancellation?");
		System.out.println(booking.toString());
		System.out.println("Enter \"confirm\" to procede (This can not be undone)");
		String confirmation = input.nextLine();
		if (confirmation.equals("confirm")) {
			try {
				booking.setActive(true);
				bdao.update(booking);
				System.out.println("Cancellation undone");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Operation canceled");
		}

	}

}
