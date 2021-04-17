package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ss.uto.de.BookingAgent;

public class BookingAgentDAO extends AbstractDAO<BookingAgent>{

	public BookingAgentDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BookingAgent> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer add(BookingAgent obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BookingAgent obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BookingAgent obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}


}
