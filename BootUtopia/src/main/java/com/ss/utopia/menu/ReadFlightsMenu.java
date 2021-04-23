/**
 * 
 */
package com.ss.utopia.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.de.Flight;

/**
 * @author Parker W.
 *
 */
public class ReadFlightsMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		GetFlightMenu menu = new GetFlightMenu();
		Flight flight;
		Scanner pause = new Scanner(System.in);
		do {
			flight = menu.getItem(conn);
			if(flight != null) {
				System.out.println(flight);
				System.out.println("Please press enter to continue...");
				pause.nextLine();
			}			
			
		} while (flight != null);

	}

}
