package com.ss.uto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.de.Flight;
import com.ss.uto.menu.GetFlightMenu;
import com.ss.uto.menu.UpdateFlightMenu;
import com.ss.uto.menu.UpdateSeatsMenu;
import com.ss.uto.utils.ConnectionUtility;

public class EmployeeService {

	ConnectionUtility conUtil;
	Connection conn = null;

	public EmployeeService() {
		conUtil = new ConnectionUtility();
	}

	public void employeeMenuOne() throws SQLException {
		System.out.println("1) Enter Flight you manage");
		System.out.println("2) Quit to previous");
		Scanner input = new Scanner(System.in);
		Integer choice;
		do {
			choice = input.nextInt();
			switch (choice) {
			case 1:
				manageFlight();
				break;
			case 2:
				return;
			default:
				System.out.println("Invalid selection, returning to main menu.");
				return;
			}
		} while (true);

	}

	public void manageFlight() throws SQLException {
		GetFlightMenu flightMenu = new GetFlightMenu();
		try {
			Flight flight = flightMenu.getItem(conn);
			System.out.println("1) View flight details.");
			System.out.println("2) Update flight details.");
			System.out.println("3) Add seats to flight.");
			System.out.println("4) Quit to previous.");

			Scanner input = new Scanner(System.in);
			Integer choice = input.nextInt();
			boolean done = false;
			do {
				switch (choice) {
				case 1:
					System.out.println(flight);
					break;
				case 2:
					UpdateFlightMenu updateFlightMenu = new UpdateFlightMenu();
					updateFlightMenu.operate(conn);
					break;
				case 3:
					UpdateSeatsMenu updateSeatsMenu = new UpdateSeatsMenu();
					updateSeatsMenu.operate(conn);
					break;
				case 4:
					System.out.println("Returning to previous menu");
					done = true;
					break;
				default:
					System.out.println("Unkown choice selection, returning to previous menu.");
					done = true;
					break;
				}

			} while (!done);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}
}
