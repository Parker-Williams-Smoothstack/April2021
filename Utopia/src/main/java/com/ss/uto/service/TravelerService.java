/**
 * 
 */
package com.ss.uto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.uto.dao.BookingAgentDAO;
import com.ss.uto.dao.BookingDAO;
import com.ss.uto.dao.BookingUserDAO;
import com.ss.uto.dao.FlightBookingDAO;
import com.ss.uto.dao.UserDAO;
import com.ss.uto.de.Booking;
import com.ss.uto.de.BookingAgent;
import com.ss.uto.de.BookingUser;
import com.ss.uto.de.Flight;
import com.ss.uto.de.FlightBooking;
import com.ss.uto.de.User;
import com.ss.uto.menu.GetFlightMenu;
import com.ss.uto.utils.ConnectionUtility;

/**
 * @author Parker W.
 *
 */
public class TravelerService {

	ConnectionUtility conUtil;
	Connection conn = null;
	User member;

	public TravelerService() {
		conUtil = new ConnectionUtility();
	}

	public void menuOne() throws ClassNotFoundException, SQLException {
		Scanner input = new Scanner(System.in);
		UserDAO udao = new UserDAO(conn);

		Integer number = 0;
		System.out.println("Please enter your Membership Number (or 0 to go back): ");
		do {

			number = input.nextInt();
			List<User> users = udao.getData("select * from user where id = ?", number);
			if (users.size() == 0) {
				// Invalid user number
				System.out.println("Sorry, could not find a member with that number. Please try again.");
				continue;
			} else {
				member = users.get(0);
				menuTwo();
			}

		} while (number != 0);
	}

	public void menuTwo() throws SQLException, ClassNotFoundException {
		BookingDAO bdao = new BookingDAO(conn);
		FlightBookingDAO fbdao = new FlightBookingDAO(conn);
		BookingAgentDAO badao = new BookingAgentDAO(conn);
		BookingUserDAO budao = new BookingUserDAO(conn);

		System.out.println("1) Book a ticket");
		System.out.println("2) Cancel an upcoming trip");
		System.out.println("3) Quit to previous");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Integer choice;
		do {

			choice = input.nextInt();
			switch (choice) {
			case 1:
				GetFlightMenu flightMenu = new GetFlightMenu();
				Flight flight = flightMenu.getItem(conn);
				Booking booking = new Booking();
				FlightBooking fb = new FlightBooking();

				booking.setActive(true);
				fb.setBooking(booking);
				fb.setFlight(flight);

				try {
					bdao.add(booking);
					fbdao.add(fb);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				break;
			case 2:
				List<BookingAgent> baList = badao.getData("select * from booking_agent where agent_id = ?", member.getId());
				List<BookingUser> buList = budao.getData("select * from booking_user where agent_id = ?", member.getId());
				
				if(baList.size() == 0) {
					if(buList.size() == 0) {
						//member has no bookings
					} else {
						//member is a user
					}
				}  else {
					//member is an agent
				}

			}

		} while (true);

	}

}
