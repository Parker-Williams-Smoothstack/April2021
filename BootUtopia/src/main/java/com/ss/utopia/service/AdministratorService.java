/**
 * 
 */
package com.ss.utopia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.de.Flight;


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
	
	@Autowired
	FlightDAO flightDAO;

	@GetMapping("/flights")
	public List<Flight> getFlights() {
		return flightDAO.getAll();
	}

}
