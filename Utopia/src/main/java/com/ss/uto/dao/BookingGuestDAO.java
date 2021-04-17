/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ss.uto.de.BookingGuest;

/**
 * @author Parker W.
 *
 */
public class BookingGuestDAO extends AbstractDAO<BookingGuest>{

	public BookingGuestDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BookingGuest> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer add(BookingGuest obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BookingGuest obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BookingGuest obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

}
