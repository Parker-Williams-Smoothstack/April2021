/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Parker W.
 *
 */
public abstract class AbstractDAO<T> {

	Connection conn = null;

	public AbstractDAO(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Performs the given query, assumed to be an add, and will return the generated
	 * keys from the add
	 * 
	 * @param query the query to execute
	 * @param vals  the parameters of the query in the order they appear in the
	 *              query
	 * @return the generated primary key
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer addPK(String query, Object... vals) throws ClassNotFoundException, SQLException {
		PreparedStatement stmt = conn.prepareStatement(query);
		int count = 1;
		for (Object o : vals) {
			stmt.setObject(count++, o);
		}
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next())
			return rs.getInt(1);
		return null;
	}

	/**
	 * Updates the database with the given query, good for updating or deleting
	 * 
	 * @param query the query to execute
	 * @param vals  the values the query needs in the order they appear
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void update(String query, Object... vals) throws ClassNotFoundException, SQLException {
		PreparedStatement stmt = conn.prepareStatement(query);
		int count = 1;
		for (Object o : vals) {
			stmt.setObject(count++, o);
		}
		stmt.executeUpdate();
	}

	/**
	 * Takes the given query with any parameters and returns the table as a list of
	 * objects.
	 * 
	 * @param query the query to execute
	 * @param vals  the parameters the query needs
	 * @return the list of objects in the resulting table
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<T> getData(String query, Object... vals) throws ClassNotFoundException, SQLException {
		PreparedStatement stmt = conn.prepareStatement(query);
		int count = 1;
		for (Object o : vals) {
			stmt.setObject(count++, o);
		}
		ResultSet rs = stmt.executeQuery();
		return parseData(rs);
	}

	/**
	 * Takes a given result set from a query and converts it into a list of objects
	 * 
	 * @param rs the result set to parse
	 * @return the result set as a list
	 */
	public abstract List<T> parseData(ResultSet rs) throws ClassNotFoundException, SQLException;

	/**
	 * Adds the given object to its respective table
	 * 
	 * @param obj the object to add
	 */
	public abstract Integer add(T obj) throws ClassNotFoundException, SQLException;

	/**
	 * Updates the given object in the table to the new value
	 * 
	 * @param obj the
	 */
	public abstract void update(T obj) throws ClassNotFoundException, SQLException;

	/**
	 * 
	 * @param obj
	 */
	public abstract void delete(T obj) throws ClassNotFoundException, SQLException;

}
