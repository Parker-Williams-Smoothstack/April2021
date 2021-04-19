/**
 * 
 */
package com.ss.uto.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.dao.UserDAO;
import com.ss.uto.dao.UserRoleDAO;
import com.ss.uto.de.User;
import com.ss.uto.de.UserRole;

/**
 * @author Parker W.
 *
 */
public class UpdateEmployeeMenu implements Menu {

	@Override
	public void operate(Connection conn) throws SQLException {
		User workingUser = new GetEmployeeMenu().getItem(conn);
		Scanner input = new Scanner(System.in);
		UserDAO udao = new UserDAO(conn);

		// Start asking for the new employee data
		// presumed to be a user who happens to have a specific user_role
		System.out.println(
				"Please enter the following information for the Employee.\nEnter a blank line at any time to cancel.");
		System.out.print("Given name: ");
		String gName = input.nextLine();
		workingUser.setGivenName(gName);
		System.out.print("Family name: ");
		String fName = input.nextLine();
		workingUser.setFamilyName(fName);
		System.out.print("Username: ");
		String uName = input.nextLine();
		workingUser.setUsername(uName);
		System.out.print("Email: ");
		String email = input.nextLine();
		workingUser.setEmail(email);
		System.out.print("Password: ");
		String pass = input.nextLine();
		workingUser.setPassword(pass);
		System.out.print("Phone: ");
		String phone = input.nextLine();
		workingUser.setPhone(phone);
		System.out.print("Role id number: ");
		Integer role_id = input.nextInt();
		// find the user_role that corresponds to this role_id. Do we need to actually
		// do that? Doesn't it get handled by the relation? Meh, adds validation, keep
		// it how it is.
		UserRoleDAO urdao = new UserRoleDAO(conn);
		UserRole role;
		try {
			role = urdao.getData("select * from user_role where id = ?", role_id).get(0);
			workingUser.setRole(role);
			udao.update(workingUser);

			System.out.print("Id number: ");
			Integer id = input.nextInt();
			udao.getData("update user set id = ? where ?", id, workingUser.getId());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
