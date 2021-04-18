/**
 * 
 */
package com.ss.uto.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.ss.uto.dao.UserDAO;
import com.ss.uto.dao.UserRoleDAO;
import com.ss.uto.de.User;
import com.ss.uto.de.UserRole;

/**
 * @author Parker W. Prompts the user for all the information to create a new
 *         user, creates a user based on that information, then passes it to the
 *         Data Access Object responsible for handling it in the server.
 */
public class AddEmployeeMenu implements Menu {

	@Override
	public void operate(Connection conn) {
		try {
			UserDAO adao = new UserDAO(conn);
			User workingUser = new User();

			Scanner input = new Scanner(System.in);

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
			System.out.print("Role id number: "); // Default this to only be the role_id for an employee?
			Integer role_id = input.nextInt();
			// find the user_role that corresponds to this role_id. Do we need to actually
			// do that? Doesn't it get handled by the relation? Meh, adds validation, keep
			// it how it is.
			UserRoleDAO urdao = new UserRoleDAO(conn);
			UserRole role = urdao.getData("select * from user_role where id = ?", role_id).get(0);
			workingUser.setRole(role);

			System.out.print("Id number: ");
			Integer id = input.nextInt();
			workingUser.setId(id);
			adao.add(workingUser);

			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
