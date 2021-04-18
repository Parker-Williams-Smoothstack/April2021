/**
 * 
 */
package com.ss.uto.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.de.User;

/**
 * @author Parker W.
 *
 */
public class ReadEmployeesMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException{
		GetEmployeeMenu selectionMenu = new GetEmployeeMenu();
		User employee;
		Scanner pause = new Scanner(System.in);
		do {
			employee = selectionMenu.getItem(conn);
			System.out.println(employee.toString());
			System.out.println("Press enter to contine...");
			pause.nextInt();
			
		} while( employee != null);
		pause.close();
	}

}
