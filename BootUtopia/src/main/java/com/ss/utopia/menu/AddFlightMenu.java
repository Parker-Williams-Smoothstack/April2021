/**
 * 
 */
package com.ss.utopia.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.uto.dao.FlightDAO;
import com.ss.uto.dao.RouteDAO;
import com.ss.uto.de.Airport;
import com.ss.uto.de.Flight;
import com.ss.uto.de.Route;

/**
 * @author Parker W.
 */
public class AddFlightMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		// Get the origin airport
		Flight flight = new Flight();
		FlightDAO fdao = new FlightDAO(conn);
		GetAirportMenu airportMenu = new GetAirportMenu();	
		Scanner input = new Scanner(System.in);
		Airport destPort = null;
		Route route = null;

		Airport originPort = airportMenu.getItem(conn); // get the origin airport

		// Get the destination airport or create a new one first
		System.out.println("What would you like to do for the destination?");
		System.out.println("1) Select existing airport");
		System.out.println("2) Create new airport first");
		System.out.println("0) Cancel");
		boolean completed = false;
		while (!completed)
			switch (input.nextInt()) {
			case 0:
				throw new SQLException();
			case 2:
				new AddAirportMenu().operate(conn); // create new airport
			case 1: // fall through to selection
				destPort = airportMenu.getItem(conn);
				completed = true;
				break;
			default:
				System.out.println("Invalid selection, please chose either 0, 1, or 2");
			}

		// Get route for the flight
		RouteDAO rdao = new RouteDAO(conn);

		if (destPort == null) {
			throw new SQLException();
		}

		try {
			List<Route> routes = rdao.getData("select * from route where origin_id = ?, destination_id = ?",
					originPort.getCode(), destPort.getCode());
			if (routes.size() == 0) {
				// no routes found, create a new one
				Route brandNewRoute = new Route();
				brandNewRoute.setDestination(destPort);
				brandNewRoute.setOrigin(originPort);
				rdao.add(brandNewRoute);
				route = brandNewRoute;
			} else {
				route = routes.get(0);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		flight.setRoute(route);
		
		//Pick an existing
		flight.setDepatureTime(new GetDepartureMenu().getItem(conn));
		
		try {
			fdao.add(flight);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
