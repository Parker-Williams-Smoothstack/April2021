/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ss.uto.de.FlightBooking;

/**
 * @author Parker W.
 *
 */
public class FlightBookingDAO extends AbstractDAO<FlightBooking> {

	public FlightBookingDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<FlightBooking> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer add(FlightBooking obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(FlightBooking obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(FlightBooking obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

}
