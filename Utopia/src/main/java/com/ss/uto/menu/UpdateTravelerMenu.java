/**
 * 
 */
package com.ss.uto.menu;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.dao.PassengerDAO;
import com.ss.uto.de.Booking;
import com.ss.uto.de.Passenger;

/**
 * @author Parker W.
 *
 */
public class UpdateTravelerMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		PassengerDAO pdao = new PassengerDAO(conn);
		Scanner input = new Scanner(System.in);
		Passenger passenger = new GetPassengerMenu().getItem(conn);
		
		System.out.println("Please select a booking");
		Booking booking = new GetBookingMenu().getItem(conn);
		System.out.print("Please enter your given name: ");
		String givenName = input.nextLine();
		System.out.print("\nPlease enter your family name: ");
		String familyName = input.nextLine();
		System.out.println("\nPlease enter your date of birth (yyyy-mm-dd");
		Date dob = Date.valueOf(input.nextLine());
		System.out.println("\nPlease enter your gender: ");
		String gender = input.nextLine();
		System.out.println("\nPlease enter your address: ");
		String address = input.nextLine();
		
		passenger.setAddress(address);
		passenger.setGender(gender);
		passenger.setDateOfBirth(dob);
		passenger.setFamilyName(familyName);
		passenger.setGivenName(givenName);
		passenger.setBooking(booking);
		
		try {
			pdao.add(passenger);
			System.out.println("Added the passenger successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	

}
