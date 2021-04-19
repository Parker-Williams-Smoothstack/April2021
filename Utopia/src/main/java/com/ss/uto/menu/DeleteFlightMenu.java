/**
 * 
 */
package com.ss.uto.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.dao.FlightDAO;
import com.ss.uto.de.Flight;

/**
 * @author Parker W.
 *
 */
public class DeleteFlightMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		Flight flight = new GetFlightMenu().getItem(conn);
		FlightDAO fdao = new FlightDAO(conn);
		Scanner input = new Scanner(System.in);

		System.out.println("WARNING: You are about to delete the following flight");
		System.out.println(flight);
		System.out.println("This can NOT be undone. Please enter \"confirm\" to delete.");
		String confirmation = input.nextLine();
		if (confirmation.equals("confirm")) {
			try {
				fdao.delete(flight);
				System.out.println("Employee deleted.");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Cancelling deletion.");
		}
		//clear the input for the any other menues that might become confused
		input.nextLine();
		input.close();

	}

}
