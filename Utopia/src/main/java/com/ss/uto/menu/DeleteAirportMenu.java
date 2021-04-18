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
public class DeleteAirportMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		// Present all the available Airports in a orderly fashion
		Airport deletingAirport = new GetAirportMenu().getItem(conn);
		Scanner input = new Scanner(System.in);
		AirportDAO adao = new AirportDAO(conn);

		// confirm delete
		System.out.println("WARNING: You are about to delete the following Airport");
		System.out.println(deletingAirport.toString());
		System.out.println("Enter \"confirm\" to procede (This can not be undone)");
		String confirmation = input.nextLine();
		if (confirmation.equals("confirm")) {
			try {
				adao.delete(deletingAirport);
				System.out.println("Deleted the airport");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Deletion canceled");
		}

		input.close();
	}

}
