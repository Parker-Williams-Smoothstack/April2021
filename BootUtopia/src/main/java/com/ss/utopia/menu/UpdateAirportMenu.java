/**
 * 
 */
package com.ss.utopia.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.dao.AirportDAO;
import com.ss.uto.de.Airport;

/**
 * @author Parker W.
 *
 */
public class UpdateAirportMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		Airport updatingAirport = new GetAirportMenu().getItem(conn);
		Scanner input = new Scanner(System.in);
		AirportDAO adao = new AirportDAO(conn);

		// get the new airport name
		System.out.print("Please enter the new name: ");
		String updatedName = input.nextLine();
		if (updatedName.equals("")) {
			return;
		} else if (updatedName.length() > 45) {
			System.err.println("City name too long, please restrict to 45 characters or less.");
			throw new IllegalArgumentException();
		}
		updatingAirport.setCityName(updatedName);
		try {
			adao.update(updatingAirport);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.print("\nPlease enter the new 3-letter code: ");
		String updatedCode = input.nextLine();
		if (updatedName.equals("")) {
			throw new IllegalArgumentException();
		} else if (updatedName.length() != 3) {
			System.err.println("City code incorrect length, must be exactly 3 characters long.");
			throw new IllegalArgumentException();
		}
		try {
			adao.getData("update airport set iada_id = ? where city = ?", updatedCode, updatedName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
