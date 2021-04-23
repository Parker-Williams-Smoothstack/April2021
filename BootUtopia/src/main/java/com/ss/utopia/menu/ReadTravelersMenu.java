/**
 * 
 */
package com.ss.utopia.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.de.Passenger;

/**
 * @author Parker W.
 *
 */
public class ReadTravelersMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		GetPassengerMenu display = new GetPassengerMenu();
		Passenger passenger;
		Scanner pause = new Scanner(System.in);
		do {
			passenger = display.getItem(conn);
			if(passenger != null) {
				System.out.println(passenger.toString());
				System.out.println("Press enter to continue...");
				pause.nextLine();
			}
			

		} while(passenger != null);
		
	}

	

}
