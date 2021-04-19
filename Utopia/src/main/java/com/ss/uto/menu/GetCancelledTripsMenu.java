/**
 * 
 */
package com.ss.uto.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.uto.dao.BookingDAO;
import com.ss.uto.de.Booking;

/**
 * @author Parker W.
 *
 */
public class GetCancelledTripsMenu implements GetMenu<Booking> {

	@Override
	public Booking getItem(Connection conn) throws SQLException {
		try {
			BookingDAO bdao = new BookingDAO(conn);
			List<Booking> list = bdao.getData("select * from booking where is_active = ?", false);

			Integer page = 0;
			Scanner input = new Scanner(System.in);
			do {
				for (int i = 1; i <= 7; i++) {
					if ((7 * page) + (i - 1) < list.size())
						System.out.print(i + ") " + list.get((7 * page) + (i - 1)).toString() + "\n");
				}
				System.out.print("8) Previous Page\n");
				System.out.print("9) Next Page\n");
				System.out.print("0) Exit\n");
				System.out.print("Please enter your selection: ");

				switch (input.nextInt()) {
				case 0:
					System.out.println("Exiting the Booking Selection Menu");
					input.nextLine();
					input.close();
					return null;
				case 1:
					input.nextLine();
					input.close();
					return list.get(7 * page);
				case 2:
					input.nextLine();
					input.close();
					return list.get((7 * page) + 1);
				case 3:
					input.nextLine();
					input.close();
					return list.get((7 * page) + 2);
				case 4:
					input.nextLine();
					input.close();
					return list.get((7 * page) + 3);
				case 5:
					input.nextLine();
					input.close();
					return list.get((7 * page) + 4);
				case 6:
					input.nextLine();
					input.close();
					return list.get((7 * page) + 5);
				case 7:
					input.nextLine();
					input.close();
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
