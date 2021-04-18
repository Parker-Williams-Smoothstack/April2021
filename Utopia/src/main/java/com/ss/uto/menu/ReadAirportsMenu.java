/**
 * 
 */
package com.ss.uto.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.uto.dao.AirportDAO;
import com.ss.uto.de.Airport;

/**
 * @author Parker W.
 *
 */
public class ReadAirportsMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		try {
			AirportDAO adao = new AirportDAO(conn);
			List<Airport> list = adao.getAll();
			Airport updatingAirport = null;

			Integer page = 0;
			Scanner input = new Scanner(System.in);
			do {
				for (int i = 1; i <= 7; i++)
					System.out.print(i + ") " + list.get((7 * page) + (i - 1)).toString() + "\n");
				System.out.print("8) Previous Page\n");
				System.out.print("9) Next Page\n");
				System.out.print("0) Exit\n");
				System.out.print("Please enter your selection: ");

				switch (input.nextInt()) {
				case 0:
					System.out.println("Exiting the Airport Update Menu");
					input.close();
					return;
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
					break;
				case 8:
					if (page > 0)
						page -= 1;
					break;
				case 9:
					if (page < (list.size() / 7) + (list.size() % 7 == 0 ? 0 : 1))
						page += 1;
					break;
				default:
					System.err.println("Invalid selection, please try again with a single digit number.");
				}

			} while (updatingAirport == null);
			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
