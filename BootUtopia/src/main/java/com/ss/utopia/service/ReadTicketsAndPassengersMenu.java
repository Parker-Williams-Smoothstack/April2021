/**
 * 
 */
package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.de.Booking;

/**
 * @author Parker W.
 *
 */
public class ReadTicketsAndPassengersMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		GetBookingMenu display = new GetBookingMenu();
		Booking booking;
		Scanner pause = new Scanner(System.in);
		do {
			booking = display.getItem(conn);
			if(booking != null) {
				System.out.println(booking.toString());
				System.out.println("Press enter to continue...");
				pause.nextLine();
			}
			

		} while(booking != null);
		
	}



}
