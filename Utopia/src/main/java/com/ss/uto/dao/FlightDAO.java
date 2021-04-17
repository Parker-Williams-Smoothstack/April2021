package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ss.uto.de.Flight;

public class FlightDAO extends AbstractDAO<Flight> {

	public FlightDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Flight> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer add(Flight obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Flight obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Flight obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Flight> getAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
