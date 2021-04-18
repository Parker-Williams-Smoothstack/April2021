package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.de.User;

public class UserDAO extends AbstractDAO<User> {

	public UserDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<User> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<User> list = new ArrayList<>();
		while (rs.next()) {
			User obj = new User();

			obj.setId(rs.getInt("id"));
			obj.setGivenName(rs.getString("given_name"));
			obj.setFamilyName(rs.getString("family_name"));
			obj.setUsername(rs.getString("username"));
			obj.setEmail(rs.getString("email"));
			obj.setPassword(rs.getString("password"));
			obj.setPhone(rs.getString("phone"));

			UserRoleDAO urdao = new UserRoleDAO(this.conn);
			obj.setRole(urdao.getData("select * from user_role where id = ?", rs.getInt("role_id")).get(0));

			list.add(obj);
		}
		return list;
	}

	@Override
	public Integer add(User obj) throws ClassNotFoundException, SQLException {
		Integer key = super.addPK(
				"INSERT INTO user (role_id, given_name, family_name, username, email, password, phone) VALUES (?,?,?,?,?,?,?)",
				obj.getRole().getId(), obj.getGivenName(), obj.getFamilyName(), obj.getUsername(),
				obj.getEmail(), obj.getPassword(), obj.getPhone());
		obj.setId(key);
		return key;
	}

	@Override
	public void update(User obj) throws ClassNotFoundException, SQLException {
		super.update(
				"UPDATE user set role_id = ?, given_name = ?, family_name = ?, username = ?, email = ?, password = ?, phone = ? where id = ?",
				obj.getRole().getId(), obj.getGivenName(), obj.getFamilyName(), obj.getUsername(), obj.getEmail(),
				obj.getPassword(), obj.getPhone(), obj.getId());
	}

	@Override
	public void delete(User obj) throws ClassNotFoundException, SQLException {
		super.update("delete from user where id = ?", obj.getId());

	}

	@Override
	public List<User> getAll() throws ClassNotFoundException, SQLException {
		return super.getData("select * from user");
	}

}
