/**
 * 
 */
package com.ss.utopia.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.ss.utopia.dao.AirportDAO;
import com.ss.utopia.de.Airport;

/**
 * @author Parker W.
 *
 */
public class DeleteAirportMenu implements Menu {
	@Autowired
	AirportDAO adao;

	@Override
	public void operate(Connection conn) throws SQLException {
		// Present all the available Airports in a orderly fashion
		Airport deletingAirport = new GetAirportMenu().getItem(conn);
		Scanner input = new Scanner(System.in);

		// confirm delete
		System.out.println("WARNING: You are about to delete the following Airport");
		System.out.println(deletingAirport.toString());
		System.out.println("Enter \"confirm\" to procede (This can not be undone)");
		String confirmation = input.nextLine();
		if (confirmation.equals("confirm")) {
			adao.delete(deletingAirport);
			System.out.println("Deleted the airport");

		} else {
			System.out.println("Deletion canceled");
		}
	}

}
