/**
 * 
 */
package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ss.uto.dao.FlightDAO;

/**
 * @author Parker W.
 *
 */
public class GetDepartureMenu implements GetMenu<Date> {

	@Override
	public Date getItem(Connection conn) throws SQLException {
		// Present all the available Airports in a orderly fashion
				try {
					List<Date> list = new ArrayList<>();
					FlightDAO fdao = new FlightDAO(conn);
					fdao.getAll().parallelStream().forEach(f -> list.add(f.getDepatureTime()));

					Integer page = 0;
					Scanner input = new Scanner(System.in);
					do {
						for (int i = 1; i <= 7; i++) {
							if((7 * page) + (i - 1) < list.size())
								System.out.print(i + ") " + list.get((7 * page) + (i - 1)).toString() + "\n");
						}
						System.out.print("8) Previous Page\n");
						System.out.print("9) Next Page\n");
						System.out.print("0) Exit\n");
						System.out.print("Please enter your selection: ");

						switch (input.nextInt()) {
						case 0:
							System.out.println("Exiting the User Selection Menu");
							return null;
						case 1:
							return list.get(7 * page);
						case 2:
							return list.get((7 * page) + 1);
						case 3:
							return list.get((7 * page) + 2);
						case 4:
							return list.get((7 * page) + 3);
						case 5:
							return list.get((7 * page) + 4);
						case 6:
							return list.get((7 * page) + 5);
						case 7:
							return list.get((7 * page) + 6);
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

					} while (true);

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				return null;
	}

}
