/**
 * 
 */
package com.ss.uto.menu;

import java.sql.Connection;
import java.util.List;
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
	public void operate(Connection conn) {
		try {

			final Integer EMPLOYEE_ROLE_ID = 1;
			UserDAO adao = new UserDAO(conn);
			List<User> list = adao.getData("select * from user where role_id = ?", EMPLOYEE_ROLE_ID);
			User workingUser = null;

			Integer page = 0;
			Scanner input = new Scanner(System.in);
			do {
				for (int i = 1; i <= 7; i++)
					System.out.print(i + ") " + list.get((7 * page) + (i - 1)).toString() + "\n");
				System.out.print("8) Previous Page\n");
				System.out.print("9) Next Page\n");
				System.out.print("0) Exit\n");
				System.out.print("Please enter your selection: ");

				switch (input.nextInt()) {
				case 0:
					System.out.println("Exiting the Airport Update Menu");
					input.close();
					return;
				case 1:
					workingUser = list.get(7 * page);
					break;
				case 2:
					workingUser = list.get((7 * page) + 1);
					break;
				case 3:
					workingUser = list.get((7 * page) + 2);
					break;
				case 4:
					workingUser = list.get((7 * page) + 3);
					break;
				case 5:
					workingUser = list.get((7 * page) + 4);
					break;
				case 6:
					workingUser = list.get((7 * page) + 5);
					break;
				case 7:
					workingUser = list.get((7 * page) + 6);
					break;
				case 8:
					if (page > 0)
						page -= 1;
					break;
				case 9:
					if (page < (list.size() / 7) + (list.size() % 7 == 0 ? 0 : 1))
						page += 1;
					break;
				default:
					System.err.println("Invalid selection, please try again with a single digit number.");
				}

			} while (workingUser == null);

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
			UserRole role = urdao.getData("select * from user_role where id = ?", role_id).get(0);
			workingUser.setRole(role);
			adao.update(workingUser);

			System.out.print("Id number: ");
			Integer id = input.nextInt();
			adao.getData("update user set id = ? where ?", id, workingUser.getId());

			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
