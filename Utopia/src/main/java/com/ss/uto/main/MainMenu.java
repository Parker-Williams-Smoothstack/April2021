/**
 * 
 */
package com.ss.uto.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.service.AdministratorService;
import com.ss.uto.service.EmployeeService;
import com.ss.uto.service.TravelerService;

/**
 * @author Parker W.
 *
 */
public class MainMenu {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Integer choice;

		EmployeeService employee = new EmployeeService();
		AdministratorService admin = new AdministratorService();
		TravelerService traveler = new TravelerService();
		do {
			System.out.println("Welcome to the Utopia Airlines Management System. Which category of a user are you?"
					+ "\n1) Employee" + "\n2) Administrator" + "\n3) Traveler");
			choice = input.nextInt();
			switch (choice) {
			case 1:
				employee.employeeMenuOne();
				break;
			case 2:
				admin.mainAdminMenu();
				break;
			case 3:
				traveler.menuOne();
				break;
			default:
				System.out.println("Unrecognized role, please chose either 1, 2, or 3");
			}
		} while (true);// specifications imply that this should go forever

	}

}
