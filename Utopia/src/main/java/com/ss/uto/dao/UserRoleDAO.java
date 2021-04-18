package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.de.UserRole;

public class UserRoleDAO extends AbstractDAO<UserRole> {

	public UserRoleDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<UserRole> parseData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<UserRole> list = new ArrayList<>();
		while (rs.next()) {
			UserRole obj = new UserRole();
			obj.setName(rs.getString("name"));
			obj.setId(rs.getInt("id"));
			list.add(obj);
		}
		return list;
	}

	@Override
	public Integer add(UserRole obj) throws ClassNotFoundException, SQLException {
		Integer key = super.addPK("INSERT INTO user_role (name) VALUES (?)", obj.getName());
		obj.setId(key);
		return key;
	}

	@Override
	public void update(UserRole obj) throws ClassNotFoundException, SQLException {
		super.update("update user_role set name = ? where id = ?", obj.getName(), obj.getId());
		
	}

	@Override
	public void delete(UserRole obj) throws ClassNotFoundException, SQLException {
		super.update("delete from user_role where id = ?", obj.getId());
		
	}

	@Override
	public List<UserRole> getAll() throws ClassNotFoundException, SQLException {
		return super.getData("select * from user_role");
	}

}
