/**
 * 
 */
package com.ss.uto.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Parker W.
 *
 *	Service class, handles connections to the server
 */
public class ConnectionUtility {
	
	private final String driver = "com.mysql.jdbc.cj.Driver";
	private final String url = "jdbc:mysql://localhost:8080/Utopia";
	//private final String username = "root";
	//private final String password = "";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url);	//Data base doesn't have a password I believe, so should be fine with just url
		return con;
	}

}
