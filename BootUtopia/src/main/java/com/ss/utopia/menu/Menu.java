/**
 * 
 */
package com.ss.utopia.menu;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Parker W. Functional Interface for menus, serves to standardize the
 *         menus and ensure that they all have a way to be used.
 */
public interface Menu {

	public abstract void operate(Connection conn) throws SQLException;

}
