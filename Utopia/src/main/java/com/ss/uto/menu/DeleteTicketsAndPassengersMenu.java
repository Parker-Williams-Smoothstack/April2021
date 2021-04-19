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
public class DeleteTicketsAndPassengersMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		// Present all the available Airports in a orderly fashion
				Booking deletingBooking = new GetBookingMenu().getItem(conn);
				Scanner input = new Scanner(System.in);
				BookingDAO bdao = new BookingDAO(conn);

				// confirm delete
				System.out.println("WARNING: You are about to delete the following Booking");
				System.out.println(deletingBooking.toString());
				System.out.println("Enter \"confirm\" to procede (This can not be undone)");
				String confirmation = input.nextLine();
				if (confirmation.equals("confirm")) {
					try {
						bdao.delete(deletingBooking);
						System.out.println("Deleted the booking");
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}

				} else {
					System.out.println("Deletion canceled");
				}
		
	}

	

}
