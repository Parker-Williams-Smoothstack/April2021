/**
 * 
 */
package com.ss.uto.service;

import java.sql.Connection;
import java.sql.SQLException;
import com.ss.uto.menu.AddAirportMenu;
import com.ss.uto.menu.DeleteAirportMenu;
import com.ss.uto.menu.ReadAirportsMenu;
import com.ss.uto.menu.UpdateAirportMenu;
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

			// add flight code

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}

		// Display all available airports
		// take user's selection
		// display all other airports
		// take user's selection or let user create new one
		// path to add Airport on creating new one
		// display departure dates
		// user picks one or more date
		// list of departure times
		// user picks one time or creates a new one
	}

	public void updateFlight() {
		// TODO
	}

	public void deleteFlight() {
		// TODO
	}

	public void readFlight() {
		// TODO
	}

	public void addSeat() {
		// TODO
	}

	public void updateSeat() {
		// TODO
	}

	public void deleteSeat() {
		// TODO
	}

	public void readSeat() {
		// TODO
	}

	public void addTicketsPassengers() {
		// TODO
	}

	public void updateTicketsPassengers() {
		// TODO
	}

	public void deleteTicketsPassengers() {
		// TODO
	}

	public void readTicketsPassengers() {
		// TODO
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

	public void addEmployee() {
		// TODO
	}

	public void updateEmployee() {
		// TODO
	}

	public void deleteEmployee() {
		// TODO
	}

	public void readEmployee() {
		// TODO
	}

	public void overrideTripCancellation() {
		// TODO
	}

}
