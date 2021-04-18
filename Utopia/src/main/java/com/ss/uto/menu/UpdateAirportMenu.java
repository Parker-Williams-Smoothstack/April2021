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
public class UpdateAirportMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		// Present all the available Airports in a orderly fashion
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
					updatingAirport = list.get(7 * page);
					break;
				case 2:
					updatingAirport = list.get((7 * page) + 1);
					break;
				case 3:
					updatingAirport = list.get((7 * page) + 2);
					break;
				case 4:
					updatingAirport = list.get((7 * page) + 3);
					break;
				case 5:
					updatingAirport = list.get((7 * page) + 4);
					break;
				case 6:
					updatingAirport = list.get((7 * page) + 5);
					break;
				case 7:
					updatingAirport = list.get((7 * page) + 6);
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

			// get the new airport name
			System.out.print("Please enter the new name: ");
			String updatedName = input.nextLine();
			if (updatedName.equals("")) {
				input.close();
				return;
			} else if (updatedName.length() > 45) {
				input.close();
				System.err.println("City name too long, please restrict to 45 characters or less.");
				throw new IllegalArgumentException();
			}
			updatingAirport.setCityName(updatedName);
			adao.update(updatingAirport);
			// get the new code

			System.out.print("\nPlease enter the new 3-letter code: ");
			String updatedCode = input.nextLine();
			if (updatedName.equals("")) {
				input.close();
				throw new IllegalArgumentException();
			} else if (updatedName.length() != 3) {
				input.close();
				System.err.println("City code incorrect length, must be exactly 3 characters long.");
				throw new IllegalArgumentException();
			}
			adao.getData("update airport set iada_id = ? where city = ?", updatedCode, updatedName);
			input.close();
			// update the airport in the base to the new name first, then update it with the
			// new code
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Get the selected Airport
		// get the new information on that airport
		// update the database
	}

}
