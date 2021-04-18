/**
 * 
 */
package com.ss.uto.service;

import java.sql.Connection;
import java.sql.SQLException;
import com.ss.uto.menu.AddAirportMenu;
import com.ss.uto.menu.AddEmployeeMenu;
import com.ss.uto.menu.AddFlightMenu;
import com.ss.uto.menu.AddSeatsMenu;
import com.ss.uto.menu.DeleteAirportMenu;
import com.ss.uto.menu.DeleteEmployeeMenu;
import com.ss.uto.menu.DeleteFlightMenu;
import com.ss.uto.menu.DeleteSeatsMenu;
import com.ss.uto.menu.ReadAirportsMenu;
import com.ss.uto.menu.ReadEmployeesMenu;
import com.ss.uto.menu.ReadFlightsMenu;
import com.ss.uto.menu.ReadSeatsMenu;
import com.ss.uto.menu.UpdateAirportMenu;
import com.ss.uto.menu.UpdateEmployeeMenu;
import com.ss.uto.menu.UpdateFlightMenu;
import com.ss.uto.menu.UpdateSeatsMenu;
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
		// TODO
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
		// TODO
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
		// TODO
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
		// TODO
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

	public void addTicketsPassengers() {
		// TODO
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight. Also requests submitting tickets to a currently non-existing
		// Ticket table

		// Suppose that the booking table takes the place of the ticket table
	}

	public void updateTicketsPassengers() {
		// TODO
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight. Also requests submitting tickets to a currently non-existing
		// Ticket table

		// Suppose that the booking table takes the place of the ticket table
	}

	public void deleteTicketsPassengers() {
		// TODO
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight. Also requests submitting tickets to a currently non-existing
		// Ticket table

		// Suppose that the booking table takes the place of the ticket table
	}

	public void readTicketsPassengers() {
		// TODO
		// Specifications of the given database do not lend themselves to meeting the
		// specifications of the assignment in this regard.
		// Assignment asks for first, business, and economy seating as unique types and
		// for a seat_table, but the given database lacks
		// this seat_table and only has capacity in the airplane type and reserved seats
		// in the flight. Also requests submitting tickets to a currently non-existing
		// Ticket table

		// Suppose that the booking table takes the place of the ticket table
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

	public void addTraveler() {
		// TODO
	}

	public void updateTraveler() {
		// TODO
	}

	public void deleteTraveler() {
		// TODO
	}

	public void readTraveler() {
		// TODO
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

	public void overrideTripCancellation() {
		// TODO
	}

}
