/**
 * 
 */
package com.ss.uto.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.dao.BookingDAO;
import com.ss.uto.de.Booking;

/**
 * @author Parker W.
 *
 */
public class UpdateTicketsAndPassengersMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		Booking updatingBooking = new GetBookingMenu().getItem(conn);
		Scanner input = new Scanner(System.in);
		BookingDAO bdao = new BookingDAO(conn);

		System.out.print("Please enter your confirmation code: ");
		updatingBooking.setConfirmationCode(input.nextLine());
		System.out.print("\nPlease enter y/n for if your booking is active: ");
		String active = input.nextLine();
		if (active.toLowerCase().charAt(0) == 'y') {
			updatingBooking.setActive(true);
		} else {
			updatingBooking.setActive(false);
		}

		input.close();
		try {
			bdao.update(updatingBooking);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
