/**
 * 
 */
package com.ss.uto.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.dao.AirportDAO;
import com.ss.uto.de.Airport;

/**
 * @author Parker W.
 *
 */
public class AddAirportMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		Airport port = new Airport();
		Scanner input = new Scanner(System.in);
		System.out.println("Entering a new Airport, enter a blank line at any time to stop");
		System.out.print("Please enter the airport's 3-Letter code: ");
		String code = input.nextLine();
		if (code.equals("")) {
			// User chose to stop
			conn.close();
			input.close();
			return;
		}
		if (!code.matches("\\D\\D\\D")) {
			System.err.println("\nERROR: Airport code must be three letters long exactly.");
			input.close();
			throw new IllegalArgumentException();
		}
		port.setCode(code);

		System.out.print("\nPlease enter the airport's home city: ");
		String city = input.nextLine();
		if (city.equals("")) {
			// user chose to stop
			conn.close();
			input.close();
			return;
		}
		if (city.length() > 45) {
			System.err.println("\nInvalid city name, must be between 1 and 45 letters long.");
			input.close();
			throw new IllegalArgumentException();
		}
		port.setCityName(city);
		//clear the input for the any other menues that might become confused
		input.nextLine();
		input.close();
		AirportDAO adao = new AirportDAO(conn);
		try {
			adao.add(port);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
