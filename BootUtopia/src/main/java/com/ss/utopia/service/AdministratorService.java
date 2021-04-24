/**
 * 
 */
package com.ss.utopia.service;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ss.utopia.menu.AddAirportMenu;
import com.ss.utopia.menu.AddEmployeeMenu;
import com.ss.utopia.menu.AddFlightMenu;
import com.ss.utopia.menu.AddSeatsMenu;
import com.ss.utopia.menu.AddTicketsAndPassengersMenu;
import com.ss.utopia.menu.AddTravelersMenu;
import com.ss.utopia.menu.DeleteAirportMenu;
import com.ss.utopia.menu.DeleteEmployeeMenu;
import com.ss.utopia.menu.DeleteFlightMenu;
import com.ss.utopia.menu.DeleteSeatsMenu;
import com.ss.utopia.menu.DeleteTicketsAndPassengersMenu;
import com.ss.utopia.menu.DeleteTravelerMenu;
import com.ss.utopia.menu.OverrideCancellationMenu;
import com.ss.utopia.menu.ReadAirportsMenu;
import com.ss.utopia.menu.ReadEmployeesMenu;
import com.ss.utopia.menu.ReadFlightsMenu;
import com.ss.utopia.menu.ReadSeatsMenu;
import com.ss.utopia.menu.ReadTicketsAndPassengersMenu;
import com.ss.utopia.menu.ReadTravelersMenu;
import com.ss.utopia.menu.UpdateAirportMenu;
import com.ss.utopia.menu.UpdateEmployeeMenu;
import com.ss.utopia.menu.UpdateFlightMenu;
import com.ss.utopia.menu.UpdateSeatsMenu;
import com.ss.utopia.menu.UpdateTicketsAndPassengersMenu;
import com.ss.utopia.menu.UpdateTravelerMenu;

/**
 * @author Parker W.
 *
 *         Administrator class, has permission to do the following:
 *         Add/Update/Delete/Read flights Add/Update/Delete/Read seats
 *         Add/Update/Delete/Read Tickets and Passengers Add/Update/Delete/Read
 *         Airports Add/Update/Delete/Read Travelers Add/Update/Delete/Read
 *         Employees Override trip cancellation for a ticket
 */
@Repository
public class AdministratorService {

	@Autowired
	JdbcTemplate template;

	public void mainAdminMenu() throws SQLException {

		Scanner input;
		Integer choice;
		do {
			System.out.println("1) Manage flights");
			System.out.println("2) Manage seats");
			System.out.println("3) Manage tickets");
			System.out.println("4) Manage airports");
			System.out.println("5) Manage travelers");
			System.out.println("6) Manage employees");
			System.out.println("7) Manage cancellations");
			System.out.println("8) Quit");
			input = new Scanner(System.in);
			choice = input.nextInt();
			switch (choice) {
			case 1:
				flightMenu();
				break;
			case 2:
				seatMenu();
				break;
			case 3:
				ticketMenu();
				break;
			case 4:
				airportMenu();
				break;
			case 5:
				travelerMenu();
				break;
			case 6:
				employeeMenu();
				break;
			case 7:
				overrideTripCancellation();
				break;
			case 8:
			default:
				return;

			}
		} while (true);

	}

	public void employeeMenu() throws SQLException {
		System.out.println("1) Read");
		System.out.println("2) Add");
		System.out.println("3) Update");
		System.out.println("4) Delete");
		System.out.println("5) Cancel");
		Scanner input = new Scanner(System.in);
		Integer choice = input.nextInt();
		switch (choice) {
		case 1:
			readEmployee();
			break;
		case 2:
			addEmployee();
			break;
		case 3:
			updateEmployee();
			break;
		case 4:
			deleteEmployee();
			break;
		case 5:
		default:
			return;

		}

	}

	public void travelerMenu() throws SQLException {
		System.out.println("1) Read");
		System.out.println("2) Add");
		System.out.println("3) Update");
		System.out.println("4) Delete");
		System.out.println("5) Cancel");
		Scanner input = new Scanner(System.in);
		Integer choice = input.nextInt();
		switch (choice) {
		case 1:
			readTraveler();
			break;
		case 2:
			addTraveler();
			break;
		case 3:
			updateTraveler();
			break;
		case 4:
			deleteTraveler();
			break;
		case 5:
		default:
			return;

		}

	}

	public void airportMenu() throws SQLException {
		System.out.println("1) Read");
		System.out.println("2) Add");
		System.out.println("3) Update");
		System.out.println("4) Delete");
		System.out.println("5) Cancel");
		Scanner input = new Scanner(System.in);
		Integer choice = input.nextInt();

		switch (choice) {
		case 1:
			readAirport();
			break;
		case 2:
			addAirport();
			break;
		case 3:
			updateAirport();
			break;
		case 4:
			deleteAirport();
			break;
		case 5:
		default:
			return;
		}

	}

	public void ticketMenu() throws SQLException {
		System.out.println("1) Read");
		System.out.println("2) Add");
		System.out.println("3) Update");
		System.out.println("4) Delete");
		System.out.println("5) Cancel");
		Scanner input = new Scanner(System.in);
		Integer choice = input.nextInt();

		switch (choice) {
		case 1:
			readTicketsPassengers();
			break;
		case 2:
			addTicketsPassengers();
			break;
		case 3:
			updateTicketsPassengers();
			break;
		case 4:
			deleteTicketsPassengers();
			break;
		case 5:
		default:
			return;

		}

	}

	public void flightMenu() throws SQLException {
		System.out.println("1) Read");
		System.out.println("2) Add");
		System.out.println("3) Update");
		System.out.println("4) Delete");
		System.out.println("5) Cancel");
		Scanner input = new Scanner(System.in);
		Integer choice = input.nextInt();

		switch (choice) {
		case 1:
			readFlight();
			break;
		case 2:
			addFlight();
			break;
		case 3:
			updateFlight();
			break;
		case 4:
			deleteFlight();
			break;
		case 5:
		default:
			return;

		}

	}

	public void seatMenu() throws SQLException {
		System.out.println("1) Read");
		System.out.println("2) Add");
		System.out.println("3) Update");
		System.out.println("4) Delete");
		System.out.println("5) Cancel");
		Scanner input = new Scanner(System.in);
		Integer choice = input.nextInt();

		switch (choice) {
		case 1:
			readSeat();
			break;
		case 2:
			addSeat();
			break;
		case 3:
			updateSeat();
			break;
		case 4:
			deleteSeat();
			break;
		case 5:
		default:
			return;

		}

	}

	public void addFlight() throws SQLException {

		AddFlightMenu menu = new AddFlightMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void updateFlight() throws SQLException {

		UpdateFlightMenu menu = new UpdateFlightMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void deleteFlight() throws SQLException {

		DeleteFlightMenu menu = new DeleteFlightMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void readFlight() throws SQLException {

		ReadFlightsMenu menu = new ReadFlightsMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void addSeat() throws SQLException {
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight.

		// suppose that the seats table is replaced by the difference between
		// airplane_type.max_capacity and flight.reserved_seats with no difference in
		// classes on account of the single flight.seat_price

		AddSeatsMenu menu = new AddSeatsMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void updateSeat() throws SQLException {
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight.

		// suppose that the seats table is replaced by the difference between
		// airplane_type.max_capacity and flight.reserved_seats with no difference in
		// classes on account of the single flight.seat_price

		UpdateSeatsMenu menu = new UpdateSeatsMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void deleteSeat() throws SQLException {
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight.

		// suppose that the seats table is replaced by the difference between
		// airplane_type.max_capacity and flight.reserved_seats with no difference in
		// classes on account of the single flight.seat_price

		DeleteSeatsMenu menu = new DeleteSeatsMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void readSeat() throws SQLException {
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight.

		// suppose that the seats table is replaced by the difference between
		// airplane_type.max_capacity and flight.reserved_seats with no difference in
		// classes on account of the single flight.seat_price

		ReadSeatsMenu menu = new ReadSeatsMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void addTicketsPassengers() throws SQLException {
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight. Also requests submitting tickets to a currently non-existing
		// Ticket table

		// Suppose that the booking table takes the place of the ticket table and use
		// the passenger table

		AddTicketsAndPassengersMenu menu = new AddTicketsAndPassengersMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void updateTicketsPassengers() throws SQLException {
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight. Also requests submitting tickets to a currently non-existing
		// Ticket table

		// Suppose that the booking table takes the place of the ticket table

		UpdateTicketsAndPassengersMenu menu = new UpdateTicketsAndPassengersMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void deleteTicketsPassengers() throws SQLException {
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight. Also requests submitting tickets to a currently non-existing
		// Ticket table

		// Suppose that the booking table takes the place of the ticket table and use
		// the passenger table

		DeleteTicketsAndPassengersMenu menu = new DeleteTicketsAndPassengersMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void readTicketsPassengers() throws SQLException {
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight. Also requests submitting tickets to a currently non-existing
		// Ticket table

		// Suppose that the booking table takes the place of the ticket table and use
		// the passenger table

		ReadTicketsAndPassengersMenu menu = new ReadTicketsAndPassengersMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void addAirport() throws SQLException {

		AddAirportMenu menu = new AddAirportMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void updateAirport() throws SQLException {

		UpdateAirportMenu menu = new UpdateAirportMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void deleteAirport() throws SQLException {

		DeleteAirportMenu menu = new DeleteAirportMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void readAirport() throws SQLException {

		ReadAirportsMenu menu = new ReadAirportsMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void addTraveler() throws SQLException {

		AddTravelersMenu menu = new AddTravelersMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void updateTraveler() throws SQLException {

		UpdateTravelerMenu menu = new UpdateTravelerMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void deleteTraveler() throws SQLException {
		// assumed to actually be the passenger table

		DeleteTravelerMenu menu = new DeleteTravelerMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void readTraveler() throws SQLException {
		// assumed to actually be the passenger table

		ReadTravelersMenu menu = new ReadTravelersMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void addEmployee() throws SQLException {

		AddEmployeeMenu menu = new AddEmployeeMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void updateEmployee() throws SQLException {

		UpdateEmployeeMenu menu = new UpdateEmployeeMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void deleteEmployee() throws SQLException {

		DeleteEmployeeMenu menu = new DeleteEmployeeMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void readEmployee() throws SQLException {

		ReadEmployeesMenu menu = new ReadEmployeesMenu();
		menu.operate(template.getDataSource().getConnection());

	}

	public void overrideTripCancellation() throws SQLException {
		// Cancellation appears to simply delete a booking, so in order to override it a
		// user's deletion should really just set it to inactive

		OverrideCancellationMenu menu = new OverrideCancellationMenu();
		menu.operate(template.getDataSource().getConnection());

	}

}
