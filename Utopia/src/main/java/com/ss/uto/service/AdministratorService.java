/**
 * 
 */
package com.ss.uto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.menu.AddAirportMenu;
import com.ss.uto.menu.AddEmployeeMenu;
import com.ss.uto.menu.AddFlightMenu;
import com.ss.uto.menu.AddSeatsMenu;
import com.ss.uto.menu.AddTicketsAndPassengersMenu;
import com.ss.uto.menu.AddTravelersMenu;
import com.ss.uto.menu.DeleteAirportMenu;
import com.ss.uto.menu.DeleteEmployeeMenu;
import com.ss.uto.menu.DeleteFlightMenu;
import com.ss.uto.menu.DeleteSeatsMenu;
import com.ss.uto.menu.DeleteTicketsAndPassengersMenu;
import com.ss.uto.menu.DeleteTravelerMenu;
import com.ss.uto.menu.OverrideCancellationMenu;
import com.ss.uto.menu.ReadAirportsMenu;
import com.ss.uto.menu.ReadEmployeesMenu;
import com.ss.uto.menu.ReadFlightsMenu;
import com.ss.uto.menu.ReadSeatsMenu;
import com.ss.uto.menu.ReadTicketsAndPassengersMenu;
import com.ss.uto.menu.ReadTravelersMenu;
import com.ss.uto.menu.UpdateAirportMenu;
import com.ss.uto.menu.UpdateEmployeeMenu;
import com.ss.uto.menu.UpdateFlightMenu;
import com.ss.uto.menu.UpdateSeatsMenu;
import com.ss.uto.menu.UpdateTicketsAndPassengersMenu;
import com.ss.uto.menu.UpdateTravelerMenu;
import com.ss.uto.utils.ConnectionUtility;

/**
 * @author Parker W.
 *
 *         Administrator class, has permission to do the following:
 *         Add/Update/Delete/Read flights Add/Update/Delete/Read seats
 *         Add/Update/Delete/Read Tickets and Passengers Add/Update/Delete/Read
 *         Airports Add/Update/Delete/Read Travelers Add/Update/Delete/Read
 *         Employees Override trip cancellation for a ticket
 */
public class AdministratorService {
	ConnectionUtility conUtil;
	Connection conn = null;

	public AdministratorService() {
		conUtil = new ConnectionUtility();
	}

	public void mainAdminMenu() throws SQLException {

		System.out.println("1) Manage flights");
		System.out.println("2) Manage seats");
		System.out.println("3) Manage tickets");
		System.out.println("4) Manage airports");
		System.out.println("5) Manage travelers");
		System.out.println("6) Manage employees");
		System.out.println("7) Manage cancellations");
		System.out.println("8) Quit");

		Scanner input = new Scanner(System.in);
		Integer choice = input.nextInt();
		do {
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
				input.close();
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
			input.close();
			return;

		}
		input.close();

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
			input.close();
			return;

		}
		input.close();

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
			input.close();
			return;

		}
		input.close();

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
			input.close();
			return;

		}
		input.close();

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
			input.close();
			return;

		}
		input.close();

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
			input.close();
			return;

		}
		input.close();

	}

	public void addFlight() throws SQLException {

		try {
			conn = conUtil.getConnection();

			AddFlightMenu menu = new AddFlightMenu();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public void updateFlight() throws SQLException {
		try {
			conn = conUtil.getConnection();

			UpdateFlightMenu menu = new UpdateFlightMenu();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void deleteFlight() throws SQLException {
		try {
			conn = conUtil.getConnection();

			DeleteFlightMenu menu = new DeleteFlightMenu();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void readFlight() throws SQLException {
		try {
			conn = conUtil.getConnection();

			ReadFlightsMenu menu = new ReadFlightsMenu();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
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
		try {
			conn = conUtil.getConnection();

			AddSeatsMenu menu = new AddSeatsMenu();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
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
		try {
			conn = conUtil.getConnection();

			UpdateSeatsMenu menu = new UpdateSeatsMenu();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}

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
		try {
			conn = conUtil.getConnection();

			DeleteSeatsMenu menu = new DeleteSeatsMenu();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
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
		try {
			conn = conUtil.getConnection();

			ReadSeatsMenu menu = new ReadSeatsMenu();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
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
		try {
			conn = conUtil.getConnection();

			AddTicketsAndPassengersMenu menu = new AddTicketsAndPassengersMenu();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
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
		try {
			conn = conUtil.getConnection();

			UpdateTicketsAndPassengersMenu menu = new UpdateTicketsAndPassengersMenu();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
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
		try {
			conn = conUtil.getConnection();

			DeleteTicketsAndPassengersMenu menu = new DeleteTicketsAndPassengersMenu();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
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
		try {
			conn = conUtil.getConnection();

			ReadTicketsAndPassengersMenu menu = new ReadTicketsAndPassengersMenu();
			menu.operate(conn);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void addAirport() throws SQLException {
		try {
			conn = conUtil.getConnection();
			AddAirportMenu menu = new AddAirportMenu();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error adding the airport to the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void updateAirport() throws SQLException {
		try {
			conn = conUtil.getConnection();
			UpdateAirportMenu menu = new UpdateAirportMenu();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error updating the airport to the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void deleteAirport() throws SQLException {
		try {
			conn = conUtil.getConnection();
			DeleteAirportMenu menu = new DeleteAirportMenu();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error deleting the airport from the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void readAirport() throws SQLException {
		try {
			conn = conUtil.getConnection();
			ReadAirportsMenu menu = new ReadAirportsMenu();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error reading the airport from the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void addTraveler() throws SQLException {
		try {
			conn = conUtil.getConnection();
			AddTravelersMenu menu = new AddTravelersMenu();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error adding the passenger to the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public void updateTraveler() throws SQLException {
		try {
			conn = conUtil.getConnection();
			UpdateTravelerMenu menu = new UpdateTravelerMenu();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error updating the passenger in the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void deleteTraveler() throws SQLException {
		// assumed to actually be the passenger table
		try {
			conn = conUtil.getConnection();
			DeleteTravelerMenu menu = new DeleteTravelerMenu();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error deleting the passenger from the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void readTraveler() throws SQLException {
		// assumed to actually be the passenger table
		try {
			conn = conUtil.getConnection();
			ReadTravelersMenu menu = new ReadTravelersMenu();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error reading the passenger from the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void addEmployee() throws SQLException {
		try {
			conn = conUtil.getConnection();
			AddEmployeeMenu menu = new AddEmployeeMenu();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error adding the employee to the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void updateEmployee() throws SQLException {
		try {
			conn = conUtil.getConnection();
			UpdateEmployeeMenu menu = new UpdateEmployeeMenu();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error updating the employee in the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void deleteEmployee() throws SQLException {
		try {
			conn = conUtil.getConnection();
			DeleteEmployeeMenu menu = new DeleteEmployeeMenu();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error deleting the employee from the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void readEmployee() throws SQLException {
		try {
			conn = conUtil.getConnection();
			ReadEmployeesMenu menu = new ReadEmployeesMenu();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error reading the employee from the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void overrideTripCancellation() throws SQLException {
		// Cancellation appears to simply delete a booking, so in order to override it a
		// user's deletion should really just set it to inactive
		try {
			conn = conUtil.getConnection();
			OverrideCancellationMenu menu = new OverrideCancellationMenu();
			menu.operate(conn);
			conn.commit();
		} catch (Exception e) {
			System.err.println("Error reading the employee from the Utopia System.");
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

}
