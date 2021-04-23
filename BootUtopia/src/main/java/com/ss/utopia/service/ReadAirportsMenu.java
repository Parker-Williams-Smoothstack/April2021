/**
 * 
 */
package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.utopia.de.Airport;


/**
 * @author Parker W.
 *
 */
public class ReadAirportsMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		GetAirportMenu display = new GetAirportMenu();
		Airport port;
		Scanner pause = new Scanner(System.in);
		do {
			port = display.getItem(conn);
			if(port != null) {
				System.out.println(port.toString());
				System.out.println("Press enter to continue...");
				pause.nextLine();
			}			
			
		} while(port != null);
	}
	

}
