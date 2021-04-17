/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ss.uto.de.BookingPayment;

/**
 * @author Parker W.
 *
 */
public class BookingPaymentDAO extends AbstractDAO<BookingPayment> {

	public BookingPaymentDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BookingPayment> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer add(BookingPayment obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BookingPayment obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BookingPayment obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BookingPayment> getAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
