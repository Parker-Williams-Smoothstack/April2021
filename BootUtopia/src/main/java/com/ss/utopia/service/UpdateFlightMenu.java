/**
 * 
 */
package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Scanner;

import com.ss.uto.dao.FlightDAO;
import com.ss.uto.de.Airplane;
import com.ss.uto.de.Flight;
import com.ss.uto.de.Route;

/**
 * @author Parker W.
 *
 */
public class UpdateFlightMenu implements Menu{

	@Override
	public void operate(Connection conn) throws SQLException {
		Flight flight = new GetFlightMenu().getItem(conn);
		FlightDAO fdao = new FlightDAO(conn);
		Scanner input = new Scanner(System.in);
		//route_id
		Route route = new GetRouteMenu().getItem(conn);
		flight.setRoute(route);
		//airplane_id
		Airplane plane = new GetAirplaneMenu().getItem(conn);
		flight.setPlane(plane);
		//departure_time
		Date date = new GetDepartureMenu().getItem(conn);
		flight.setDepatureTime(date);
			
		//reserved_seats
		System.out.print("Please enter the number of reserved seats: ");
		Integer reservedSeats = input.nextInt();
		flight.setReservedSeats(reservedSeats);
		//seat_price
		System.out.print("\nPlease enter the price per seat: ");
		Float seatPrice = input.nextFloat();
		flight.setSeatPrice(seatPrice);
		
		try {
			fdao.update(flight);
			//id
			Integer id = input.nextInt();
			fdao.getData("update flight set id = ? where id = ?", id, flight.getId());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

	

}
