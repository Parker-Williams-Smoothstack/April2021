/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ss.uto.de.BookingUser;

/**
 * @author Parker W.
 *
 */
public class BookingUserDAO extends AbstractDAO<BookingUser> {

	public BookingUserDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BookingUser> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer add(BookingUser obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BookingUser obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BookingUser obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BookingUser> getAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
