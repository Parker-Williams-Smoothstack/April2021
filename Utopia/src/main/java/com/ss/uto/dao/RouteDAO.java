package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ss.uto.de.Route;

public class RouteDAO extends AbstractDAO<Route> {

	public RouteDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Route> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer add(Route obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Route obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Route obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Route> getAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
