package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;

public class AddSeatsMenu implements Menu {


	@Override
	public void operate(Connection conn) throws SQLException {
		//Is really the update seats menu
		new UpdateSeatsMenu().operate(conn);
		
	}

}
