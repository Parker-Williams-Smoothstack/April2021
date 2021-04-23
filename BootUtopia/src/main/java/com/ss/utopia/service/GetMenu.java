/**
 * 
 */
package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Parker W.
 *
 */
public interface GetMenu<T> {

	public T getItem(Connection conn) throws SQLException;
	
}
